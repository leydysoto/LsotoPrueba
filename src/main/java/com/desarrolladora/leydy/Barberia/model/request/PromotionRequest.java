package com.desarrolladora.leydy.Barberia.model.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PromotionRequest {

    private Integer discount;
    private List<Long> productIds;
}
