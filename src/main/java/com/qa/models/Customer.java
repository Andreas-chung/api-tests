package com.qa.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends Model {

    private String id;

    private String name;

    private List<String> pets;

    private BankDetails bankDetails;

    @Builder
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BankDetails extends  Model {

        private String accountNumber;

        private String sortCode;
    }
}
