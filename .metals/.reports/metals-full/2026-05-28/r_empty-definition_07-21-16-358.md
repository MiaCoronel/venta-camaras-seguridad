error id: file:///C:/Users/JHONATAN/OneDrive/Escritorio/DESARROLLO%20WEB/CODIGO/v1.1.3/venta-camaras-seguridad/src/main/java/com/ventacamaras/camaras/model/Resena.java:_empty_/JoinColumn#nullable#
file:///C:/Users/JHONATAN/OneDrive/Escritorio/DESARROLLO%20WEB/CODIGO/v1.1.3/venta-camaras-seguridad/src/main/java/com/ventacamaras/camaras/model/Resena.java
empty definition using pc, found symbol in pc: _empty_/JoinColumn#nullable#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 773
uri: file:///C:/Users/JHONATAN/OneDrive/Escritorio/DESARROLLO%20WEB/CODIGO/v1.1.3/venta-camaras-seguridad/src/main/java/com/ventacamaras/camaras/model/Resena.java
text:
```scala
package com.ventacamaras.camaras.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "resenas")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Resena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer calificacion;

    @Column(length = 500)
    private String comentario;

    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    @PrePersist
    protected void onCreate() {
        this.fechaCreacion = LocalDateTime.now();
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "camara_id", nul@@lable = false)
    private Camara camara;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/JoinColumn#nullable#