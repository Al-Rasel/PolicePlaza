package plaza.police.rasel.policeplaza.utility;

import java.util.Objects;

import plaza.police.rasel.policeplaza.model.SingleShop;

/**
 * Created by jacosrasel on 11/22/2017.
 */

public class WarperSingleShop {

    private SingleShop e;

    public WarperSingleShop(SingleShop e) {
        this.e = e;
    }

    public SingleShop unwrap() {
        return this.e;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WarperSingleShop that = (WarperSingleShop) o;
        return Objects.equals(e.getItemsofShop(), that.e.getItemsofShop());
    }

    @Override
    public int hashCode() {
        return Objects.hash(e.getItemsofShop());
    }
}
