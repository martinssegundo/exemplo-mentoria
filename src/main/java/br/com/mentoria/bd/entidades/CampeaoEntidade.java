package br.com.mentoria.bd.entidades;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "TB_CAPEAO")
@GenericGenerator(
        name = "SEQ_CAPEAO",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
                @Parameter(name = "sequence_name", value = "SEQ_CAPEAO"),
                @Parameter(name = "initial_value", value = "1"),
                @Parameter(name = "increment_size", value = "1")
        }
)
public class CampeaoEntidade {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CAPEAO")
    @Column(name = "ID_CAPEAO")
    private Long id;

    @Column(name = "DS_NOME")
    private String nome;
    @Column(name = "DS_EMAIL",nullable = false,unique = true)
    private String email;
    @Column(name = "DS_COR_SABER")
    private String corSabre;
    @Column(name = "QTDA_HP")
    private Long hp;
    @Column(name = "QTDA_FORCA_FISICA")
    private Long forcaFisica;
    @Column(name = "QTDA_MENTAL")
    private Long mental;
    @Column(name = "QTDA_PREVISAO")
    private Long previsao;
    @Column(name = "QTDA_HABILIDADE_SABRE")
    private Long habilidadeComSabre;
    @Column(name = "QTDA_AFINIDADE_FORCA")
    private Long afinadadeForca;

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH })
    @JoinTable(
            name = "TB_CAMPEAO_TIPO",
            joinColumns = @JoinColumn(name = "ID_CAPEAO",
                    referencedColumnName = "ID_CAPEAO"),
            inverseJoinColumns = @JoinColumn(name = "ID_TIPO_CAMPEAO",
                    referencedColumnName = "ID_TIPO_CAMPEAO"))
    private TipoCampeaoEntidade tipo;
}

