package com.tripsplanner.model.entity;

import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-05-10T15:12:51")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, BigInteger> googleID;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile SingularAttribute<Users, String> surname;
    public static volatile SingularAttribute<Users, Short> sex;
    public static volatile SingularAttribute<Users, String> name;
    public static volatile SingularAttribute<Users, BigInteger> fbID;
    public static volatile SingularAttribute<Users, Long> id;
    public static volatile SingularAttribute<Users, String> email;
    public static volatile SingularAttribute<Users, Integer> age;
    public static volatile SingularAttribute<Users, Short> enabled;

}