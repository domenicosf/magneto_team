package mutant.ml.utl;

import mutant.ml.domain.Stats;
import mutant.ml.exceptions.StatsException;

public class StatsUtil {

    public Stats getStats() throws StatsException {
        Long total = 0L;
        Long mutants = 0L;
        Double ratio = 0.0;

        Stats stats = new Stats(mutants, total, ratio);

        return stats;
    }
}
