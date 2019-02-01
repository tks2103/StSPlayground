import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import basemod.interfaces.EditCharactersSubscriber;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.rooms.AbstractRoom;

import basemod.BaseMod;
import basemod.interfaces.PostBattleSubscriber;

@SpireInitializer
public class TimeClass implements PostBattleSubscriber, EditCharactersSubscriber {

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
/*
        BaseMod.addCharacter(new WitchCharacter("The Witch"),
                "images/button.png",
                "images/portait.png"),
                TimeEnum.TimeClass);
                */
    }
}