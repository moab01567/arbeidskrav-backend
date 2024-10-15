package no.moab015.BackendBicycles.module;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Builder
@Getter
@Setter
public class Bicycle {
    private String id;
    private String name;
    private String color;
    private String model;
    private int InStock;
    private Manufacturer manufacturer;
}
