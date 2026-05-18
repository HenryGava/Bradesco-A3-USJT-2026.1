package com.example.sentinela2.specification;

import com.example.sentinela2.model.Denuncia;
import com.example.sentinela2.model.DenunciaStatus;
import com.example.sentinela2.model.TipoAmeaca;
import org.springframework.data.jpa.domain.Specification;

public class DenunciaSpecification {

    public static Specification<Denuncia> tituloOuDescricaoContem(String termo) {
        return (root, query, builder) -> builder.or(
                builder.like(builder.lower(root.get("titulo")), "%" + termo.toLowerCase() + "%"),
                builder.like(builder.lower(root.get("descricao")), "%" + termo.toLowerCase() + "%")
        );
    }

    public static Specification<Denuncia> tipoAmeacaIgual(TipoAmeaca tipoAmeaca) {
        return (root, query, builder) -> builder.equal(root.get("tipoAmeaca"), tipoAmeaca);
    }

    public static Specification<Denuncia> statusIgual(DenunciaStatus status) {
        return (root, query, builder) -> builder.equal(root.get("status"), status);
    }
}
