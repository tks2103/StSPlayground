package cards;

import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardQueueItem;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public abstract class AbstractTimeCard extends AbstractCard {

    public boolean autocast;

    public AbstractTimeCard(String id,
                            String name,
                            String imgUrl,
                            int cost,
                            String rawDescription,
                            com.megacrit.cardcrawl.cards.AbstractCard.CardType type,
                            AbstractCard.CardColor color,
                            AbstractCard.CardRarity rarity,
                            AbstractCard.CardTarget target) {
        super(id, name, imgUrl, cost, rawDescription, type, color, rarity, target);
    }

    public void triggerWhenDrawn() {
        if (this.autocast == true) {
            this.current_x = (float) Settings.WIDTH / 2.0F - 300.0F * Settings.scale;
            this.current_y = (float) Settings.HEIGHT / 2.0F;
            this.target_x = (float) Settings.WIDTH / 2.0F - 300.0F * Settings.scale;
            this.target_y = (float) Settings.HEIGHT / 2.0F;
            this.freeToPlayOnce = true;
            AbstractDungeon.actionManager.cardQueue.add(
                    new CardQueueItem(this,
                            AbstractDungeon.getCurrRoom().monsters.getRandomMonster((AbstractMonster) null,
                                    true,
                                    AbstractDungeon.cardRandomRng)));
            AbstractDungeon.actionManager.addToBottom(new DrawCardAction(AbstractDungeon.player, 1));
        }
    }
}
