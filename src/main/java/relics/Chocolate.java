package relics;

import basemod.abstracts.CustomRelic;

public class Chocolate extends CustomRelic {

    public Chocolate() {
        super("Chocolate", "images/relics/chocolate.png", RelicTier.STARTER, LandingSound.CLINK);
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }
}
