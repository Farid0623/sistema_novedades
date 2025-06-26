package cue.edu.co.sistema_novedades.model;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Setter
@Getter
@Document(collection = "novedades")
public abstract class Novedad {
    @Id
    private String id;
    private String identificacionId;
    private String nombre;
    private String apellido;
    private String programaFormacion;
    private LocalDateTime fecha;
    private String descripcion;
    private String tipo;

    public Novedad() {}

    public Novedad(String identificacionId, String nombre, String apellido, String programaFormacion, LocalDateTime fecha, String descripcion) {
        this.identificacionId = identificacionId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.programaFormacion = programaFormacion;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.tipo = getTipo();
    }

}
