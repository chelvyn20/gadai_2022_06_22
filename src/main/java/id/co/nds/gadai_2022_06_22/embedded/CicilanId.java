package id.co.nds.gadai_2022_06_22.embedded;

import java.io.Serializable;
import java.util.Objects;

public class CicilanId implements Serializable {
    private String noTransaksi;
    private Integer cicilanKe;

    public CicilanId() {
    }

    public CicilanId(String noTransaksi, Integer cicilanKe) {
        this.noTransaksi = noTransaksi;
        this.cicilanKe = cicilanKe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CicilanId that = (CicilanId) o;
        return noTransaksi.equals(that.noTransaksi) &&
        cicilanKe.equals(that.cicilanKe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noTransaksi, cicilanKe);
    }

    public String getNoTransaksi() {
        return noTransaksi;
    }

    public void setNoTransaksi(String noTransaksi) {
        this.noTransaksi = noTransaksi;
    }

    public Integer getCicilanKe() {
        return cicilanKe;
    }

    public void setCicilanKe(Integer cicilanKe) {
        this.cicilanKe = cicilanKe;
    }
}
