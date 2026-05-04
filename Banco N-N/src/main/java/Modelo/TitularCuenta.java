package Modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "titularescuentas")
public class TitularCuenta {
    @EmbeddedId
    private TitularCuentaId id;

    public TitularCuenta() {
    }

    public TitularCuenta(TitularCuentaId id) {
        this.id = id;
    }

    public TitularCuentaId getId() {
        return id;
    }

    public void setId(TitularCuentaId id) {
        this.id = id;
    }
}