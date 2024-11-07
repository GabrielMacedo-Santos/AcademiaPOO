package Academia;

import java.util.Comparator;

public class AgendaComparatorData implements Comparator<Agenda> {
    @Override
    public int compare(Agenda a1, Agenda a2) {
        return a1.getData().compareTo(a2.getData());
    }
}
