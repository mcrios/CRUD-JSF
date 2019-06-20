package Entidades;

import Entidades.Detalle;
import Entidades.Persona;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-18T14:10:50")
@StaticMetamodel(Venta.class)
public class Venta_ { 

    public static volatile SingularAttribute<Venta, Date> fecha;
    public static volatile SingularAttribute<Venta, BigDecimal> monto;
    public static volatile ListAttribute<Venta, Detalle> detalleList;
    public static volatile SingularAttribute<Venta, Persona> idPersona;
    public static volatile SingularAttribute<Venta, Integer> idVenta;

}