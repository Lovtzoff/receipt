package ru.clevertec.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.clevertec.dto.DiscountCardDto;
import ru.clevertec.service.DiscountCardService;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DiscountCardController {

    private final DiscountCardService discountCardService;

    @GetMapping("/cards")
    public ResponseEntity<List<DiscountCardDto>> getAllCards(@PathParam("size") String size,
                                                             @PathParam("page") String page) {
        return ResponseEntity.ok(discountCardService.findAll(size, page));
    }

    @GetMapping("/card")
    public ResponseEntity<DiscountCardDto> getCardById(@PathParam("id") Integer id) {
        return ResponseEntity.ok(discountCardService.findOneById(id));
    }

    @PostMapping("/card/add")
    public ResponseEntity<DiscountCardDto> addCard(@PathParam("discount") Integer discount) {
        DiscountCardDto discountCardDto = DiscountCardDto.builder()
                .discount(discount)
                .build();
        discountCardDto = discountCardService.save(discountCardDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(discountCardDto);
    }

    @PutMapping("/card/update")
    public ResponseEntity<DiscountCardDto> updateCardById(@PathParam("id") Integer id,
                                                          @PathParam("discount") Integer discount) {
        DiscountCardDto discountCardDto = DiscountCardDto.builder()
                .discount(discount)
                .build();
        discountCardDto = discountCardService.update(discountCardDto, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(discountCardDto);
    }

    @DeleteMapping("/card/remove")
    public ResponseEntity<Void> removeCardById(@PathParam("id") Integer id) {
        discountCardService.remove(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
