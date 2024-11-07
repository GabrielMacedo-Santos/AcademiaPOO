package GestaoPessoas;

import java.util.Comparator;

public class ClienteComparatorNome implements Comparator<Cliente> {
    @Override
    public int compare(Cliente c1, Cliente c2) {
        return c1.getNome().compareTo(c2.getNome());
    }
}
