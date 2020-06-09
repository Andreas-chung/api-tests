package com.qa.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends Model {

    private String id;

    private String email;

    private String firstName;

    private String lastName;

    private String occupation;

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
