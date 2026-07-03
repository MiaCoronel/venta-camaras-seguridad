error id: file:///C:/Users/JHONATAN/OneDrive/Escritorio/DESARROLLO%20WEB/PROYECTO-FINAL/versiones/v1.1.7/backend/venta-camaras-seguridad/src/main/java/com/ventacamaras/camaras/model/Cliente.java:_empty_/OneToOne#
file:///C:/Users/JHONATAN/OneDrive/Escritorio/DESARROLLO%20WEB/PROYECTO-FINAL/versiones/v1.1.7/backend/venta-camaras-seguridad/src/main/java/com/ventacamaras/camaras/model/Cliente.java
empty definition using pc, found symbol in pc: _empty_/OneToOne#
empty definition using semanticdb
empty definition using fallback
non-local guesses:

offset: 527
uri: file:///C:/Users/JHONATAN/OneDrive/Escritorio/DESARROLLO%20WEB/PROYECTO-FINAL/versiones/v1.1.7/backend/venta-camaras-seguridad/src/main/java/com/ventacamaras/camaras/model/Cliente.java
text:
```scala
package com.ventacamaras.camaras.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clientes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String email;

    private String direccion;

    private String telefono;

    @@@OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;
}


```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/OneToOne#