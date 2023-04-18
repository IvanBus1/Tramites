package Entidades;

import Entidades.Vehiculo;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-04-18T00:24:20", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Placa.class)
public class Placa_ extends Tramite_ {

    public static volatile SingularAttribute<Placa, String> estado;
    public static volatile SingularAttribute<Placa, Date> fecha_inactividad;
    public static volatile SingularAttribute<Placa, String> num_placa;
    public static volatile SingularAttribute<Placa, Vehiculo> vehiculo;

}