package br.com.mentoria.bd.entidades;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "TB_TIPO_CAMPEAO")
@GenericGenerator(
        name = "SEQ_TIPO_CAMPEAO",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
                @Parameter(name = "sequence_name", value = "SEQ_TIPO_CAMPEAO"),
                @Parameter(name = "initial_value", value = "1"),
                @Parameter(name = "increment_size", value = "1")
        }
)
public class TipoCampeao {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TIPO_CAMPEAO")
    @Column(name = "ID_TIPO_CAMPEAO")
    private Long id;

    @Column(name = "DS_TIPO_CAPEAO")
    private String tipoCampeao;
}
