package ms.ejercicio1_metodosCrud.model;

import lombok.*;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Coupons {
    private Long id;
    private String name;
    private String edad;
    private String direccion;
    private String city;
    private String animals;
    private String time;
}
