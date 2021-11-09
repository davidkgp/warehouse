package org.example.domain.productcatalog.application.rest;

import lombok.RequiredArgsConstructor;
import org.example.shared.JsonConverter;

import org.example.domain.productcatalog.core.model.command.ProductLine;
import org.example.domain.productcatalog.core.ports.incoming.AddNewProducts;
import org.example.domain.productcatalog.core.ports.incoming.SellProduct;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.util.stream.Collectors.groupingBy;

@RestController
@RequestMapping("/productcatalog")
@RequiredArgsConstructor
public class ProductCatalogController {

//    private final AddNewProducts addNewProducts;
//    private final SellProduct sellProduct;
//    private final JsonConverter<ProductLine[]> productParser;


//    @PostMapping("/add")
//    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") final MultipartFile file) throws IOException {
//        String fileContent = new String(file.getBytes(), StandardCharsets.UTF_8);
//        List<ProductLine> productLines = new ArrayList<>(Arrays.asList(Objects.requireNonNull(productParser.convert(fileContent))));
//        Map<ProductLine, Long> products = productLines.stream().collect(groupingBy(e -> e, counting()));
//        Map<ProductLine, Integer> productsConverted = new HashMap<>();
//        for (Map.Entry<ProductLine, Long> entry : products.entrySet()) {
//            productsConverted.put(entry.getKey(), entry.getValue().intValue());
//        }
//
//        AddProductsOutput productsAddedResult = addNewProducts.handle(new AddProductCommand(productsConverted));
//        String message = "Uploaded the file successfully: "
//                + file.getOriginalFilename()
//                + ", and "
//                + productsAddedResult.getAdded()
//                + " products added"
//                + ", and "
//                + productsAddedResult.getFailed()
//                + " products were not added, ";
//        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseMessage(message));
//
//    }
//
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
