import basemod.interfaces.*;
import cards.Strike_Time;
import characters.TimeCharacter;
import com.badlogic.gdx.Gdx;
import com.megacrit.cardcrawl.localization.RelicStrings;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.rooms.AbstractRoom;

import basemod.BaseMod;
import patches.TimeEnum;
import relics.Chocolate;

import java.nio.charset.StandardCharsets;

@SpireInitializer
public class TimeClass implements PostBattleSubscriber, EditCharactersSubscriber, EditCardsSubscriber,
        EditRelicsSubscriber, EditStringsSubscriber {

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

        BaseMod.addCharacter(new TimeCharacter("TimeColor"),
                "images/button.png",
                "images/portrait.png",
                TimeEnum.TimeClass);
    }

    @Override
    public void receiveEditCards() {
        BaseMod.addCard(new Strike_Time());
    }

    @Override
    public void receiveEditRelics() {
        BaseMod.addRelicToCustomPool(new Chocolate(), TimeEnum.TimeColor);
    }

    @Override
    public void receiveEditStrings() {
        String relicStrings = Gdx.files.internal("localization/Time-RelicStrings.json")
                .readString(String.valueOf(StandardCharsets.UTF_8));

        BaseMod.loadCustomStrings(RelicStrings.class, relicStrings);
    }
}