import cards.Strike_Time;
import characters.TimeCharacter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import basemod.interfaces.EditCharactersSubscriber;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.rooms.AbstractRoom;

import basemod.BaseMod;
import basemod.interfaces.EditCardsSubscriber;
import basemod.interfaces.PostBattleSubscriber;
import patches.TimeEnum;

@SpireInitializer
public class TimeClass implements PostBattleSubscriber, EditCardsSubscriber, EditCharactersSubscriber {

    private static final Logger logger = LogManager.getLogger(TimeClass.class);

    private TimeClass() {
        BaseMod.subscribe(this);
    }

    public static void initialize() {
        new TimeClass();
    }

    @Override
    public void receivePostBattle(AbstractRoom r) {
        System.out.println("Hey modder!");
    }

    @Override
    public void receiveEditCharacters() {
        logger.info("adding character");

        BaseMod.addCharacter(new TimeCharacter("Time"),
                "images/button.png",
                "images/portrait.png",
                TimeEnum.TimeClass);
    }

    @Override
    public void receiveEditCards() {
        BaseMod.addCard(new Strike_Time());
    }
}