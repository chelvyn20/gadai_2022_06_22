package id.co.nds.gadai_2022_06_22.entities.compositeId;

import java.io.Serializable;
import java.util.Objects;

public class CompositeBarangId implements Serializable {
    private String noTransaksi;

    private Integer noUrut;

    public CompositeBarangId() {
    }

    public CompositeBarangId(String noTransaksi, Integer noUrut) {
        this.noTransaksi = noTransaksi;
        this.noUrut = noUrut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompositeBarangId that = (CompositeBarangId) o;
        return noTransaksi.equals(that.noTransaksi) &&
        noUrut.equals(that.noUrut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noTransaksi, noUrut);
    }

    public String getNoTransaksi() {
        return noTransaksi;
    }

    public void setNoTransaksi(String noTransaksi) {
        this.noTransaksi = noTransaksi;
    }

    public Integer getNoUrut() {
        return noUrut;
    }

    public void setNoUrut(Integer noUrut) {
        this.noUrut = noUrut;
    }
}
