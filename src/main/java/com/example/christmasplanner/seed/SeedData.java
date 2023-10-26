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

        Decoration decoration4 = new Decoration();
        decoration4.setName(" Scented Pomander Balls");
        decoration4.setMaterials("Oranges, cloves, ribbon");
        decoration4.setDirections("Push cloves into oranges in decorative patterns, tie with ribbon, and hang for a fragrant decoration.");
        decorationRepository.save(decoration4);

        Decoration decoration5 = new Decoration();
        decoration5.setName("Wine Cork Reindeer");
        decoration5.setMaterials("Wine corks, pipe cleaners, googly eyes");
        decoration5.setDirections("Attach pipe cleaner antlers and googly eyes to wine corks to create reindeer ornaments.");
        decorationRepository.save(decoration5);

        Decoration decoration6 = new Decoration();
        decoration6.setName("Handmade Stockings");
        decoration6.setMaterials("Fabric, sewing machine, felt, ribbon");
        decoration6.setDirections("Sew personalized stockings with festive fabric and decorate with felt and ribbon.");
        decorationRepository.save(decoration6);

        Decoration decoration7 = new Decoration();
        decoration7.setName("Yarn-Wrapped Candy Canes");
        decoration7.setMaterials("Candy canes, yarn");
        decoration7.setDirections("Wrap yarn around candy canes, securing with glue, to create colorful ornaments.");
        decorationRepository.save(decoration7);

        Decoration decoration8 = new Decoration();
        decoration8.setName("Mason Jar Luminaries");
        decoration8.setMaterials("Mason jars, tea lights, decorative paper, glue");
        decoration8.setDirections("Glue decorative paper inside mason jars, place tea lights inside, and light up for a cozy atmosphere.");
        decorationRepository.save(decoration8);

        Decoration decoration9 = new Decoration();
        decoration9.setName("Christmas Card Garland");
        decoration9.setMaterials("Old Christmas cards, twine");
        decoration9.setDirections("Cut old Christmas cards into shapes and string them onto twine to create a card garland.");
        decorationRepository.save(decoration9);

        Decoration decoration10 = new Decoration();
        decoration10.setName("Cardboard Gingerbread House");
        decoration10.setMaterials("Cardboard, paint, candy decorations");
        decoration10.setDirections("Cut and paint cardboard into a gingerbread house shape, then add candy decorations.");
        decorationRepository.save(decoration10);


        Gift gift1 = new Gift();
        gift1.setName("Custom Photo Calendar");
        gift1.setDescription("Create a personalized calendar with favorite photos and memories for a unique and thoughtful gift.");
        gift1.setTag("men, women");
        giftRepository.save(gift1);

        Gift gift2 = new Gift();
        gift2.setName("Holiday-themed Scented Candles");
        gift2.setDescription("Craft scented candles with Christmas scents like cinnamon, pine, and gingerbread.");
        gift2.setTag("women");
        giftRepository.save(gift2);

        Gift gift3 = new Gift();
        gift3.setName("Personalized Christmas Storybook");
        gift3.setDescription("Create a custom Christmas storybook featuring the recipient's name, making it a cherished keepsake.");
        gift3.setTag("men, women");
        giftRepository.save(gift3);

        Gift gift4 = new Gift();
        gift4.setName("Handmade Beard Balm");
        gift4.setDescription("Create a DIY beard balm using natural ingredients and festive scents like peppermint or pine.");
        gift4.setTag("men");
        giftRepository.save(gift4);

        Gift gift5 = new Gift();
        gift5.setName("Homemade Body Scrub");
        gift5.setDescription("Create a luxurious body scrub using natural ingredients and festive scents.");
        gift5.setTag("women");
        giftRepository.save(gift5);

        Gift gift6 = new Gift();
        gift6.setName("Handmade Stuffed Animals");
        gift6.setDescription("Sew adorable stuffed animals in holiday attire.");
        gift6.setTag("children, kids");
        giftRepository.save(gift6);

        Gift gift7 = new Gift();
        gift7.setName("Handmade Jewelry");
        gift7.setDescription("Craft unique jewelry pieces using beads, wire, and gemstones.");
        gift7.setTag("women");
        giftRepository.save(gift7);

        Gift gift8 = new Gift();
        gift8.setName("Homemade Peppermint Bark");
        gift8.setDescription("Make delicious peppermint bark in holiday-themed packaging.");
        gift8.setTag("men, women");
        giftRepository.save(gift8);

        Gift gift9 = new Gift();
        gift9.setName("Crafted Advent Calendar");
        gift9.setDescription("Craft an advent calendar with small surprises for each day.");
        gift9.setTag("children, kids");
        giftRepository.save(gift9);

        Gift gift10 = new Gift();
        gift10.setName("Handmade Wooden Wine Rack");
        gift10.setDescription("Craft a wooden wine rack with holiday motifs.");
        gift10.setTag("men");
        giftRepository.save(gift10);


        StockingStuffer stockingStuffer1 = new StockingStuffer();
        stockingStuffer1.setName("Miniature Christmas Scented Soaps");
        stockingStuffer1.setDescription("Tiny soaps in holiday scents like peppermint, evergreen, and spiced apple.");
        stockingStuffer1.setTag("men, women");
        stockingStufferRepository.save(stockingStuffer1);

        StockingStuffer stockingStuffer2 = new StockingStuffer();
        stockingStuffer2.setName("Christmas-themed Cookie Mix in a Jar");
        stockingStuffer2.setDescription("Layered ingredients for making delicious Christmas cookies, complete with a recipe.");
        stockingStuffer2.setTag("men, women");
        stockingStufferRepository.save(stockingStuffer2);

        StockingStuffer stockingStuffer3 = new StockingStuffer();
        stockingStuffer3.setName("Festive Hot Cocoa Spoons");
        stockingStuffer3.setDescription("Milk chocolate spoons with marshmallow toppings, ideal for stirring into a cup of hot cocoa.");
        stockingStuffer3.setTag("men, women");
        stockingStufferRepository.save(stockingStuffer3);

        StockingStuffer stockingStuffer4 = new StockingStuffer();
        stockingStuffer4.setName("DIY Bath Bombs");
        stockingStuffer4.setDescription("Craft bath bombs with soothing scents and festive shapes.");
        stockingStuffer4.setTag("women");
        stockingStufferRepository.save(stockingStuffer4);

        StockingStuffer stockingStuffer5 = new StockingStuffer();
        stockingStuffer5.setName("DIY Snowflake Soap");
        stockingStuffer5.setDescription("Create snowflake-shaped soap with holiday scents.");
        stockingStuffer5.setTag("men");
        stockingStufferRepository.save(stockingStuffer5);

        StockingStuffer stockingStuffer6 = new StockingStuffer();
        stockingStuffer6.setName("Scented Playdough Packs");
        stockingStuffer6.setDescription("Create small packs of scented playdough with glitter and small figurines.");
        stockingStuffer6.setTag("children, kids");
        stockingStufferRepository.save(stockingStuffer6);

        StockingStuffer stockingStuffer7 = new StockingStuffer();
        stockingStuffer7.setName("Homemade Crayon Shapes");
        stockingStuffer7.setDescription("Craft unique crayon shapes in holiday molds.");
        stockingStuffer7.setTag("children, kids");
        stockingStufferRepository.save(stockingStuffer7);

        StockingStuffer stockingStuffer8 = new StockingStuffer();
        stockingStuffer8.setName("DIY Ornament Kits");
        stockingStuffer8.setDescription("Assemble ornament kits with decorating materials.");
        stockingStuffer8.setTag("children, kids");
        stockingStufferRepository.save(stockingStuffer8);

        StockingStuffer stockingStuffer9 = new StockingStuffer();
        stockingStuffer9.setName("DIY Bath Salts");
        stockingStuffer9.setDescription("Prepare bath salts with holiday scents in small jars.");
        stockingStuffer9.setTag("women");
        stockingStufferRepository.save(stockingStuffer9);

        StockingStuffer stockingStuffer10 = new StockingStuffer();
        stockingStuffer10.setName("Eggnog Spice Blend");
        stockingStuffer10.setDescription("Create a blend of ground nutmeg, cinnamon, and a touch of allspice. Package it in small spice jars. It's perfect for spicing up eggnog, lattes, or desserts.");
        stockingStuffer10.setTag("men, women");
        stockingStufferRepository.save(stockingStuffer7);

    }
}
