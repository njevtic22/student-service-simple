package com.example.studentservice.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
public class PagingUtil {
    private final ConsoleReader reader;

    public PagingUtil(ConsoleReader reader) {
        this.reader = reader;
    }

    public PageRequest getRequest() {
        int pageSize = getSize();
        int pageNumber = getNumber();
        return PageRequest.of(pageNumber, pageSize);
    }

    public int getNumber() {
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
}
