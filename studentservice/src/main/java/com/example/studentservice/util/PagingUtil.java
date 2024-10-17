package com.example.studentservice.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Component
public class PagingUtil {
    private final ConsoleReader reader;

    public PagingUtil(ConsoleReader reader) {
        this.reader = reader;
    }

    public Pageable getRequest() {
        return getRequest(() -> new String[]{"id,asc"});
    }

    public Pageable getRequest(Supplier<String[]> sortInput) {
        int pageSize = getSize();
        int pageNumber = getPage();
        Sort sort = getSort(sortInput);
        return PageRequest.of(pageNumber, pageSize, sort);
    }

    public int getPage() {
        int pageNumber = reader.nextInt("Enter desired page: ");
        while (pageNumber <= 0) {
            System.out.println(Colors.likeError("\nPage index must not be less than one.\nTry again.\n"));
            pageNumber = reader.nextInt("Enter desired page: ");
        }
        return pageNumber - 1;
    }

    public int getSize() {
        int pageNumber = reader.nextInt("Enter desired page size: ");
        while (pageNumber <= 0) {
            System.out.println(Colors.likeError("\nSize must not be less than one.\nTry again.\n"));
            pageNumber = reader.nextInt("Enter desired page size: ");
        }
        return pageNumber;
    }

    public Sort getSort(Supplier<String[]> sortInput) {
        String[] sortFields = sortInput.get();
        List<Sort.Order> orders = new ArrayList<>(sortFields.length);

        for (String field : sortFields) {
            String[] propertyAndDirection = field.split(",");
            String property = propertyAndDirection[0];
            Sort.Direction direction = Sort.DEFAULT_DIRECTION;

            if (propertyAndDirection.length > 1) {
                direction = Sort.Direction.fromOptionalString(propertyAndDirection[1]).orElse(Sort.DEFAULT_DIRECTION);
            }

            orders.add(new Sort.Order(direction, property));
        }

        return Sort.by(orders);
    }
}
