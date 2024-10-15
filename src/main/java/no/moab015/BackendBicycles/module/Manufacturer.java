package no.moab015.BackendBicycles.module;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Builder
@Getter
@Setter
public class Manufacturer {
   private int id;
   private String website;
   private String phoneNumber;
   private String name;
}
