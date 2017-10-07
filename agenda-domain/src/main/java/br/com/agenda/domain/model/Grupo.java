package br.com.agenda.domain.model;
import io.gumga.domain.GumgaModel; //TODO RETIRAR OS IMPORTS DESNECESSÁRIOS
import io.gumga.domain.GumgaMultitenancy;
import java.io.Serializable;
import java.util.*;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.validation.constraints.*;
import io.gumga.domain.domains.*;
import org.hibernate.annotations.Columns;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.envers.Audited;
import com.fasterxml.jackson.annotation.JsonIgnore;

@GumgaMultitenancy
@Audited
@Entity(name = "Grupo")
@Table(name = "Grupo", indexes = {
    @Index(name = "Grupo_gum_oi", columnList = "oi")
})
@SequenceGenerator(name = GumgaModel.SEQ_NAME, sequenceName = "SEQ_Grupo")
public class Grupo extends GumgaModel<Long> {

    @Version
    @Column(name = "version")
    private Integer version;

    @Column(name = "data")
	private Date data;
    @ManyToOne
	private Pessoa pessoa;
    @Column(name = "atividade")
	private Atividade atividade;

    public Grupo() {}

	public Date getData() {
		return this.data;
	}
	public void setData(Date data) {
		this.data = data;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Atividade getAtividade() {
		return this.atividade;
	}
	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}
}
