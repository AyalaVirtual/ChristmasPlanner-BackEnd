package com.example.christmasplanner.seed;

import com.example.christmasplanner.model.Decoration;
import com.example.christmasplanner.model.Gift;
import com.example.christmasplanner.model.StockingStuffer;
import com.example.christmasplanner.repository.DecorationRepository;
import com.example.christmasplanner.repository.GiftRepository;
import com.example.christmasplanner.repository.StockingStufferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class SeedData implements CommandLineRunner {

    private final DecorationRepository decorationRepository;
    private final GiftRepository giftRepository;
    private final StockingStufferRepository stockingStufferRepository;


    @Autowired
    public SeedData(DecorationRepository decorationRepository, GiftRepository giftRepository, StockingStufferRepository stockingStufferRepository) {
        this.decorationRepository = decorationRepository;
        this.giftRepository = giftRepository;
        this.stockingStufferRepository = stockingStufferRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        Decoration decoration1 = new Decoration();
        decoration1.setName("Christmas Village");
        decoration1.setMaterials("model houses, fake snow, figurines, snow cover blanket, miniature trees and street lamps, extension cords, nightlight bulbs");
        decoration1.setDirections("Run your extension cords and cover surface with snow cover blanket. Set houses in place and screw in nightlight bulbs. Arrange trees and street lamps, figurines, and other accessories. Throw on the snowflakes!");
        decorationRepository.save(decoration1);

        Decoration decoration2 = new Decoration();
        decoration2.setName("Pinecone Garland");
        decoration2.setMaterials("Pinecones, twine or ribbon, paint, glue, glitter");
        decoration2.setDirections("Collect pinecones and clean them if needed. Paint the tips of the pinecones and add glitter for a sparkly touch. Tie a piece of twine or ribbon to the base of each pinecone before hanging.");
        decorationRepository.save(decoration2);

        Decoration decoration3 = new Decoration();
        decoration3.setName("Mason Jar Snow Globes");
        decoration3.setMaterials("Mason jars, miniature figurines, fake snow, glue, ribbon");
        decoration3.setDirections("Glue miniature figurines to the inside of the Mason jar lid. Add fake snow to the jar. Screw the lid back on. Tie a festive ribbon around the jar's neck.");
        decorationRepository.save(decoration3);


        Gift gift1 = new Gift();
        gift1.setName("Custom Photo Calendar");
        gift1.setDescription("Create a personalized calendar with favorite photos and memories for a unique and thoughtful gift.");
        giftRepository.save(gift1);

        Gift gift2 = new Gift();
        gift2.setName("Holiday-themed Scented Candles");
        gift2.setDescription("Craft scented candles with Christmas scents like cinnamon, pine, and gingerbread.");
        giftRepository.save(gift2);

        Gift gift3 = new Gift();
        gift3.setName("Personalized Christmas Storybook");
        gift3.setDescription("Create a custom Christmas storybook featuring the recipient's name, making it a cherished keepsake.");
        giftRepository.save(gift3);


        StockingStuffer stockingStuffer1 = new StockingStuffer();
        stockingStuffer1.setName("Miniature Christmas Scented Soaps");
        stockingStuffer1.setDescription("Tiny soaps in holiday scents like peppermint, evergreen, and spiced apple.");
        stockingStufferRepository.save(stockingStuffer1);

        StockingStuffer stockingStuffer2 = new StockingStuffer();
        stockingStuffer2.setName("Christmas-themed Cookie Mix in a Jar");
        stockingStuffer2.setDescription("Layered ingredients for making delicious Christmas cookies, complete with a recipe.");
        stockingStufferRepository.save(stockingStuffer2);

        StockingStuffer stockingStuffer3 = new StockingStuffer();
        stockingStuffer3.setName("Festive Hot Cocoa Spoons");
        stockingStuffer3.setDescription("Milk chocolate spoons with marshmallow toppings, ideal for stirring into a cup of hot cocoa.");
        stockingStufferRepository.save(stockingStuffer3);

    }
}
