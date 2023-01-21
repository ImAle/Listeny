package com.listeny.listeny.web.controller;

import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class AbstractController<DTO> {

    //Literal para los números de página
    protected final String pageNumbersAttributeKey = "pageNumbers";

    //Método para obtener los números de página
    protected List<Integer> dameNumPaginas(Page<DTO>  dtos){
        List<Integer> pageNumbers = new ArrayList<>();
        int totalPages = dtos.getTotalPages();
        if (totalPages > 0) {
            pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
        }
        return pageNumbers;
    }
}
