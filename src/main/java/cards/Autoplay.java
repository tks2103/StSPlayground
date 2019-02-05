package cards;

import actions.TestAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardQueueItem;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Autoplay extends AbstractCard {

    public boolean autocast;

    public Autoplay() {
        super("Autoplay",
                "Autoplay",
                "strike.png",
                1,
                "This will Autocast",
                CardType.ATTACK,
                CardColor.RED,
                CardRarity.BASIC,
                CardTarget.ENEMY);

        this.baseDamage = 5;
        this.tags.add(CardTags.STRIKE);
        this.autocast = true;
    }

    public void triggerWhenDrawn() {
        AbstractDungeon.actionManager.addToTop(new TestAction());
        AbstractDungeon.actionManager.cardQueue.add(
                new CardQueueItem(this,
                        AbstractDungeon.getCurrRoom().monsters.getRandomMonster((AbstractMonster)null,
                                true,
                                AbstractDungeon.cardRandomRng)));
    }

    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeDamage(3);
        }
    }

    @Override
    public AbstractCard makeCopy() {
        return new Autoplay();
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        AbstractDungeon.actionManager.addToBottom(
                new DamageAction(abstractMonster,
                        new DamageInfo(abstractPlayer, damage, damageTypeForTurn),
                        AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
    }
}
