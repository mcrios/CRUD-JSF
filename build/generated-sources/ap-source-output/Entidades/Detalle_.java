package Entidades;

import Entidades.Producto;
import Entidades.Venta;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-18T14:10:50")
@StaticMetamodel(Detalle.class)
public class Detalle_ { 

    public static volatile SingularAttribute<Detalle, Integer> idDetalle;
    public static volatile SingularAttribute<Detalle, BigDecimal> cantidad;
    public static volatile SingularAttribute<Detalle, Producto> idProducto;
    public static volatile SingularAttribute<Detalle, Venta> idVenta;

}