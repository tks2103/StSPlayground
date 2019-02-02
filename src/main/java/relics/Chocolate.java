package relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.relics.AbstractRelic;

import static patches.TimeEnum.TimeClass;

public class Chocolate extends CustomRelic {

    private int energyUsed = 0;

    public Chocolate() {
        super("Chocolate", new Texture("images/relics/chocolate.png"), RelicTier.STARTER, LandingSound.CLINK);
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }

    @Override
    public void onPlayerEndTurn() {
        AbstractDungeon.actionManager.addToBottom(
                new HealAction(AbstractDungeon.player, AbstractDungeon.player, energyUsed));
        energyUsed = 0;
    }

    @Override
    public void onPlayCard(AbstractCard c, AbstractMonster m) {
        energyUsed += c.costForTurn;
    }

    @Override
    public AbstractRelic makeCopy() {
        return new Chocolate();
    }
}
