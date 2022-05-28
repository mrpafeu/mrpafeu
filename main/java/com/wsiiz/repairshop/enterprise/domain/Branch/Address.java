package com.wsiiz.repairshop.enterprise.domain.Branch;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Address {

    String street, city, state, zipCode, country;
}
