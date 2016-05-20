package dao;

import java.io.Serializable;

/**
 * Created by roski on 4/23/16.
 */
public interface Identified<PK extends Serializable> {
    public PK getId();
}
