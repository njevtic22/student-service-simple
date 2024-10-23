package com.example.studentservice.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class PagingUtil {
    private final ConsoleReader console;

    public PagingUtil(ConsoleReader console) {
        this.console = console;
    }

    public Pageable getRequest() {
        return getRequest("id", "asc");
    }

    public Pageable getRequest(String sortProperty, String sortOrder) {
        int pageSize = getSize();
        int pageNumber = getPage();
        return PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.fromString(sortOrder), sortProperty));
    }

    public Pageable getRequest(List<Pair<String, String>> sortOptions) {
        int pageSize = getSize();
        int pageNumber = getPage();
        Sort sort = getSort(sortOptions);
        return PageRequest.of(pageNumber, pageSize, sort);
    }

    public int getPage() {
        int pageNumber = console.nextInt("Enter desired page: ");
        while (pageNumber <= 0) {
            System.out.println(Colors.likeError("\nPage index must not be less than one.\nTry again.\n"));
            pageNumber = console.nextInt("Enter desired page: ");
        }
        return pageNumber - 1;
    }

    public int getSize() {
        int pageNumber = console.nextInt("Enter desired page size: ");
        while (pageNumber <= 0) {
            System.out.println(Colors.likeError("\nSize must not be less than one.\nTry again.\n"));
            pageNumber = console.nextInt("Enter desired page size: ");
        }
        return pageNumber;
    }

    public Sort getSort(List<Pair<String, String>> sortOptions) {
        String[] sortFields = getSortInputs(sortOptions);
        List<Sort.Order> orders = new ArrayList<>(sortFields.length);

        for (String field : sortFields) {
            String[] propertyAndDirection = field.split(",");
            String property = propertyAndDirection[0];
            Sort.Direction direction = Sort.DEFAULT_DIRECTION;

            if (propertyAndDirection.length > 1) {
                direction = Sort.Direction.fromString(propertyAndDirection[1]);
            }

            orders.add(new Sort.Order(direction, property));
        }

        return Sort.by(orders);
    }

    private String[] getSortInputs(List<Pair<String, String>> sortOptions) {
        Set<String> properties = new HashSet<>(sortOptions.size());
        int size = sortOptions.size();
        String[] sort = null;
        boolean read = false;

        while (!read) {
            System.out.println("\nYou can chose multiple sorting options.");
            int i = 0;
            for (Pair<String, String> option : sortOptions) {
                System.out.println(++i + ". " + option.getFirst());
            }

            String line = console.nextLine("Enter numbers of desired sorting options separated by space: ");
            String[] split = line.split("\\s+");
            sort = new String[split.length];

            try {
                for (int j = 0; j < split.length; j++) {
                    int input = Integer.parseInt(split[j]);

                    if (input <= 0 || input > size) {
                        throw new NumberFormatException("For input string: \"" + input + "\"");
                    }

                    String option = sortOptions.get(input - 1).getSecond();
                    String property = option.split(",")[0];
                    if (properties.contains(property)) {
                        throw new IllegalArgumentException("You cant select sorting by same property more than once");
                    }
                    properties.add(property);
                    sort[j] = option;
                }
                read = true;
            } catch (NumberFormatException e) {
                System.out.println(Colors.likeError("\n" + e.getMessage().substring(18) + " is not available sorting option.\nTry again."));
            } catch (IllegalArgumentException e) {
                System.out.println(Colors.likeError("\n" + e.getMessage() + ".\nTry again."));
            } finally {
                properties.clear();
            }
        }

        return sort;
    }
}
