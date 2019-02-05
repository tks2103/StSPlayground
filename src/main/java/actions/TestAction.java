package actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class TestAction extends AbstractGameAction {

    public TestAction() {
        this.duration = Settings.ACTION_DUR_MED;
        this.actionType = ActionType.HEAL;
        this.source = AbstractDungeon.player;
        this.target = AbstractDungeon.player;
    }

    @Override
    public void update() {
        if (this.duration == Settings.ACTION_DUR_MED) {
            AbstractDungeon.actionManager.addToBottom(
                    new HealAction(AbstractDungeon.player, AbstractDungeon.player, 2));
            this.isDone = true;
        }
    }
}
