package com.example.studentservice.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PagingUtil {
    private final ConsoleReader reader;

    public PagingUtil(ConsoleReader reader) {
        this.reader = reader;
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

    public Sort getSort(List<Pair<String, String>> sortOptions) {
        String[] sortFields = getSortArray(sortOptions);
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

    private String[] getSortArray(List<Pair<String, String>> sortOptions) {
        int[] inputs = getSortInputs(sortOptions);
        String[] sort = new String[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            int input = inputs[i];
            sort[i] = sortOptions.get(input - 1).getSecond();
        }

        return sort;
    }

    private int[] getSortInputs(List<Pair<String, String>> sortOptions) {
        // TODO: throw exception when same option is entered multiple times
        int size = sortOptions.size();
        int[] intInputs = null;
        boolean read = false;

        while (!read) {
            System.out.println("\nYou can chose multiple sorting options.");
            int i = 0;
            for (Pair<String, String> option : sortOptions) {
                System.out.println(++i + ". " + option.getFirst());
            }

            String line = reader.nextLine("Enter numbers of desired sorting options separated by space: ");
            String[] split = line.split("\\s+");
            intInputs = new int[split.length];

            try {
                for (int j = 0; j < split.length; j++) {
                    String input = split[j];
                    int tmp = Integer.parseInt(input);

                    if (tmp <= 0 || tmp > size) {
                        throw new NumberFormatException("For input string: \"" + tmp + "\"");
                    }
                    intInputs[j] = tmp;
                }
                read = true;
            } catch (NumberFormatException e) {
                System.out.println(Colors.likeError("\n" + e.getMessage().substring(18) + " is not available sorting option.\nTry again."));
            }
        }

        return intInputs;
    }
}
