package org.example.domain.productcatalog.application.rest;

import lombok.RequiredArgsConstructor;
import org.example.domain.productcatalog.application.rest.input.ProductLine;
import org.example.domain.productcatalog.application.rest.input.Products;
import org.example.domain.productcatalog.core.model.command.AddProductCommand;
import org.example.domain.productcatalog.core.model.output.AddProductsOutput;
import org.example.domain.productcatalog.core.ports.incoming.AddNewProducts;
import org.example.domain.productcatalog.core.ports.incoming.SellProduct;
import org.example.kernel.JsonConverter;
import org.example.kernel.output.ResponseMessage;
import org.javatuples.Pair;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

@RestController
@RequestMapping("/productcatalog")
@RequiredArgsConstructor
public class ProductCatalogController {

    private final AddNewProducts addNewProducts;
    private final SellProduct sellProduct;
    @Qualifier("productJsonParser")
    private final JsonConverter<Products> productParser;


    @PostMapping("/add")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") final MultipartFile file) throws IOException {
        String fileContent = new String(file.getBytes(), StandardCharsets.UTF_8);
        List<ProductLine> productLines = Arrays.asList(productParser.convert(fileContent).getProducts());
        Map<ProductLine, Long> products = productLines.stream().collect(groupingBy(e -> e, counting()));


        AddProductsOutput productsAddedResult = addNewProducts.handle(new AddProductCommand(products
                .entrySet()
                .stream()
                .map(entry -> Pair.with(entry.getKey(), entry.getValue().intValue())).collect(Collectors.toSet())));
        String message = "Uploaded the file successfully: "
                + file.getOriginalFilename()
                + ", and "
                + productsAddedResult.getAdded()
                + " products added"
                + ", and "
                + productsAddedResult.getFailed()
                + " products were not added, ";
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseMessage(message));

    }

//    @PostMapping("/sell")
//    public ResponseEntity<SellProductResponse> sellProduct(@RequestBody final SellProductRequest sellProductRequest) {
//
//        final SellCommand sellCommand = new SellCommand(sellProductRequest.getProductName(), sellProductRequest.getQuantity());
//
//        final Optional<SellOutput> sellOutput = sellProduct.handle(sellCommand);
//
//        return sellOutput
//                .map(output -> ResponseEntity.accepted()
//                        .body(new SellProductResponse(output.getSellStatus()))
//                ).orElseGet(() -> ResponseEntity.notFound().build());
//
//
//    }
}
