package ms.tienda.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Ciber {
    private String impresora;
    private String laptop;
    private String computadora;
    private String mouse;
    private Long id;
}
