package Entidades;

import Entidades.Licencia;
import Entidades.Tramite;
import Entidades.Vehiculo;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-04-15T00:38:57", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Persona.class)
public class Persona_ { 

    public static volatile SingularAttribute<Persona, String> apellidoPaterno;
    public static volatile SingularAttribute<Persona, Boolean> discapacitado;
    public static volatile SingularAttribute<Persona, Integer> id_persona;
    public static volatile SingularAttribute<Persona, Date> fechaNacimiento;
    public static volatile ListAttribute<Persona, Tramite> tramites;
    public static volatile SingularAttribute<Persona, String> telefono;
    public static volatile SingularAttribute<Persona, String> nombre;
    public static volatile SingularAttribute<Persona, String> rfc;
    public static volatile ListAttribute<Persona, Licencia> licencias;
    public static volatile ListAttribute<Persona, Vehiculo> vehiculos;
    public static volatile SingularAttribute<Persona, String> apellidoMaterno;

}