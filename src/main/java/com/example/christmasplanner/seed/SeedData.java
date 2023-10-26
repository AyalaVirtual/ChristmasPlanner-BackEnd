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
        decoration1.setImage("https://www.poughkeepsiejournal.com/gcdn/presto/2021/12/03/PWES/22497a9a-77f0-4d4e-a821-2bb0de89cef6-20211127_171627.jpg?crop=3914,2202,x0,y161&width=660&height=372&format=pjpg&auto=webp");
        decorationRepository.save(decoration1);

        Decoration decoration2 = new Decoration();
        decoration2.setName("Pinecone Garland");
        decoration2.setMaterials("Pinecones, twine or ribbon, paint, glue, glitter");
        decoration2.setDirections("Collect pinecones and clean them if needed. Paint the tips of the pinecones and add glitter for a sparkly touch. Tie a piece of twine or ribbon to the base of each pinecone before hanging.");
        decoration2.setImage("https://busybeingjennifer.com/wp-content/uploads/2018/10/DSC_0136-1024x759.jpg");
        decorationRepository.save(decoration2);

        Decoration decoration3 = new Decoration();
        decoration3.setName("Mason Jar Snow Globes");
        decoration3.setMaterials("Mason jars, miniature figurines, fake snow, glue, ribbon");
        decoration3.setDirections("Glue miniature figurines to the inside of the Mason jar lid. Add fake snow to the jar. Screw the lid back on. Tie a festive ribbon around the jar's neck.");
        decoration3.setImage("https://i1.wp.com/www.thinkmakeshareblog.com/wp-content/uploads/Snowglobe-Workshop-_-thinkmakeshareblog-4.jpg?w=822&ssl=1");
        decorationRepository.save(decoration3);

        Decoration decoration4 = new Decoration();
        decoration4.setName("Scented Pomander Balls");
        decoration4.setMaterials("Oranges, cloves, ribbon");
        decoration4.setDirections("Push cloves into oranges in decorative patterns, tie with ribbon, and hang for a fragrant decoration.");
        decoration4.setImage("https://inhabitat.com/wp-content/blogs.dir/1/files/2013/11/Orange-pomander-centerpiece.jpg");
        decorationRepository.save(decoration4);

        Decoration decoration5 = new Decoration();
        decoration5.setName("Wine Cork Reindeer");
        decoration5.setMaterials("Wine corks, pipe cleaners, googly eyes");
        decoration5.setDirections("Attach pipe cleaner antlers and googly eyes to wine corks to create reindeer ornaments.");
        decoration5.setImage("https://m.media-amazon.com/images/I/81z16eqUOfL._AC_SX679_.jpg");
        decorationRepository.save(decoration5);

        Decoration decoration6 = new Decoration();
        decoration6.setName("Handmade Stockings");
        decoration6.setMaterials("Fabric, sewing machine, felt, ribbon");
        decoration6.setDirections("Sew personalized stockings with festive fabric and decorate with felt and ribbon.");
        decoration6.setImage("https://farm8.staticflickr.com/7543/16197556246_764474afdc.jpg");
        decorationRepository.save(decoration6);

        Decoration decoration7 = new Decoration();
        decoration7.setName("Yarn-Wrapped Candy Canes");
        decoration7.setMaterials("Candy canes, yarn");
        decoration7.setDirections("Wrap yarn around candy canes, securing with glue, to create colorful ornaments.");
        decoration7.setImage("https://factorydirectcraft.com/pimages/20180810095556-121307_med/set_of_rustic_jute_candy_cane_ornaments_medium.jpg");
        decorationRepository.save(decoration7);

        Decoration decoration8 = new Decoration();
        decoration8.setName("Mason Jar Luminaries");
        decoration8.setMaterials("Mason jars, tea lights, decorative paper, glue");
        decoration8.setDirections("Glue decorative paper inside mason jars, place tea lights inside, and light up for a cozy atmosphere.");
        decoration8.setImage("https://hearthandvine.com/wp-content/uploads/2019/11/lighted-mason-jar-luminaries.jpg");
        decorationRepository.save(decoration8);

        Decoration decoration9 = new Decoration();
        decoration9.setName("Christmas Card Garland");
        decoration9.setMaterials("Old Christmas cards, twine");
        decoration9.setDirections("Cut old Christmas cards into shapes and string them onto twine to create a card garland.");
        decoration9.setImage("https://2.bp.blogspot.com/-IFwlJqTylm4/UM5XlXRhmZI/AAAAAAAAAFY/x8zMYUrGtGg/s640/Garland+card+display+001.jpg");
        decorationRepository.save(decoration9);

        Decoration decoration10 = new Decoration();
        decoration10.setName("Cardboard Gingerbread House");
        decoration10.setMaterials("Cardboard, paint, candy decorations");
        decoration10.setDirections("Cut and paint cardboard into a gingerbread house shape, then add candy decorations.");
        decoration10.setImage("https://3.bp.blogspot.com/-Q9A7ANw1s5s/VICkBVL-zaI/AAAAAAAAGos/uoDnHCGxLCw/s1600/IMG_3850.JPG");
        decorationRepository.save(decoration10);


        Gift gift1 = new Gift();
        gift1.setName("Christmas Potpourri");
        gift1.setDescription("Create a homemade potpourri blend with all natural ingredients. Some ingredients you could use ingredients such as a fresh orange and cranberries, as well as traditional holiday spices like cinnamon, nutmeg and cloves.");
        gift1.setTag("men, women");
        gift1.setImage("https://www.rd.com/wp-content/uploads/2017/12/10_Potpourri_26-Handmade-Gifts-for-Everyone-on-Your-List-Lindsey-Galvez.jpg?fit=700%2C467?fit=700,700");
        giftRepository.save(gift1);

        Gift gift2 = new Gift();
        gift2.setName("Holiday-themed Scented Candles");
        gift2.setDescription("Craft scented candles with Christmas scents like cinnamon, pine, and gingerbread.");
        gift2.setTag("women");
        gift2.setImage("https://i.etsystatic.com/19693480/r/il/143bc6/2126686785/il_1588xN.2126686785_m2ja.jpg");
        giftRepository.save(gift2);

        Gift gift3 = new Gift();
        gift3.setName("Personalized Christmas Storybook");
        gift3.setDescription("Create a custom Christmas storybook featuring the recipient's name, making it a cherished keepsake.");
        gift3.setTag("kids, children");
        gift3.setImage("https://assets.website-files.com/57513cfafcdc27ff2e4df970/5cc9605ed546875e61762fd7_Website_NBC_Cover.jpg");
        giftRepository.save(gift3);

        Gift gift4 = new Gift();
        gift4.setName("Handmade Beard Balm");
        gift4.setDescription("Create a DIY beard balm using natural ingredients and festive scents like peppermint or pine.");
        gift4.setTag("men");
        gift4.setImage("https://www.growforagecookferment.com/wp-content/uploads/2017/11/juniper-spice-beard-balm-1.jpg");
        giftRepository.save(gift4);

        Gift gift5 = new Gift();
        gift5.setName("Homemade Body Scrub");
        gift5.setDescription("Create a luxurious body scrub using natural ingredients and festive scents.");
        gift5.setTag("women");
        gift5.setImage("https://alifeadjacent.com/wp-content/uploads/2020/12/diy_holiday_sugar_scrubs.jpg");
        giftRepository.save(gift5);

        Gift gift6 = new Gift();
        gift6.setName("Handmade Stuffed Animals");
        gift6.setDescription("Sew, knit, or crochet adorable stuffed animals in holiday attire.");
        gift6.setTag("children, kids");
        gift6.setImage("https://www.crazypatterns.net/uploads/cache/items/2021/11/75697/preview/crochet-pattern-deer-gingerbread-and-snowman-christmas-bundle-3985097716-600x450.jpg");
        giftRepository.save(gift6);

        Gift gift7 = new Gift();
        gift7.setName("Handmade Jewelry");
        gift7.setDescription("Craft unique jewelry pieces using beads, wire, and gemstones.");
        gift7.setTag("women");
        gift7.setImage("https://i.etsystatic.com/7483547/r/il/e8ab4f/2565221733/il_1588xN.2565221733_emz0.jpg");
        giftRepository.save(gift7);

        Gift gift8 = new Gift();
        gift8.setName("Homemade Peppermint Bark");
        gift8.setDescription("Make delicious peppermint bark in holiday-themed packaging.");
        gift8.setTag("men, women");
        gift8.setImage("https://cdn.greatlifepublishing.net/wp-content/uploads/sites/2/2014/01/22141206/peppermint-bark-recipe.jpg");
        giftRepository.save(gift8);

        Gift gift9 = new Gift();
        gift9.setName("Crafted Advent Calendar");
        gift9.setDescription("Craft an advent calendar with small surprises for each day.");
        gift9.setTag("children, kids");
        gift9.setImage("https://m.media-amazon.com/images/I/71doCJdeXEL._AC_SX679_.jpg");
        giftRepository.save(gift9);

        Gift gift10 = new Gift();
        gift10.setName("Handmade Wooden Wine Rack");
        gift10.setDescription("Craft a wooden wine rack with holiday motifs.");
        gift10.setTag("men");
        gift10.setImage("https://i.etsystatic.com/7164259/r/il/ac0850/2497951909/il_1588xN.2497951909_2jvg.jpg");
        giftRepository.save(gift10);


        StockingStuffer stockingStuffer1 = new StockingStuffer();
        stockingStuffer1.setName("Miniature Christmas Scented Soaps");
        stockingStuffer1.setDescription("Tiny soaps in holiday scents like peppermint, evergreen, and spiced apple.");
        stockingStuffer1.setTag("men, women");
        stockingStuffer1.setImage("https://i.etsystatic.com/8547159/r/il/3cbe73/1131246211/il_340x270.1131246211_q3mi.jpg");
        stockingStufferRepository.save(stockingStuffer1);

        StockingStuffer stockingStuffer2 = new StockingStuffer();
        stockingStuffer2.setName("Christmas-themed Cookie Mix in a Jar");
        stockingStuffer2.setDescription("Layered ingredients for making delicious Christmas cookies, complete with a recipe.");
        stockingStuffer2.setTag("men, women");
        stockingStuffer2.setImage("https://i.etsystatic.com/16211445/r/il/59c80b/1733644805/il_1588xN.1733644805_k0fm.jpg");
        stockingStufferRepository.save(stockingStuffer2);

        StockingStuffer stockingStuffer3 = new StockingStuffer();
        stockingStuffer3.setName("Festive Hot Cocoa Bombs");
        stockingStuffer3.setDescription("Milk chocolate balls filled with chocolate milk powder and marshmallows. Just add hot milk and  stir to have a decadent and delicious cup of hot chocolate!");
        stockingStuffer3.setTag("men, women");
        stockingStuffer3.setImage("https://i.etsystatic.com/7002621/r/il/c4f2af/4430509424/il_1588xN.4430509424_iikm.jpg");
        stockingStufferRepository.save(stockingStuffer3);

        StockingStuffer stockingStuffer4 = new StockingStuffer();
        stockingStuffer4.setName("DIY Bath Bombs");
        stockingStuffer4.setDescription("Craft bath bombs with soothing scents and festive shapes.");
        stockingStuffer4.setTag("women");
        stockingStuffer4.setImage("https://i.etsystatic.com/14446965/r/il/7a8a56/4338326934/il_1588xN.4338326934_annu.jpg");
        stockingStufferRepository.save(stockingStuffer4);

        StockingStuffer stockingStuffer5 = new StockingStuffer();
        stockingStuffer5.setName("DIY Snowflake Soap");
        stockingStuffer5.setDescription("Create snowflake-shaped soap with holiday scents.");
        stockingStuffer5.setTag("men, women");
        stockingStuffer5.setImage("https://i.etsystatic.com/21747766/r/il/220609/4337907714/il_1588xN.4337907714_3vwu.jpg");
        stockingStufferRepository.save(stockingStuffer5);

        StockingStuffer stockingStuffer6 = new StockingStuffer();
        stockingStuffer6.setName("Scented Playdough Packs");
        stockingStuffer6.setDescription("Create small packs of scented playdough.");
        stockingStuffer6.setTag("children, kids");
        stockingStuffer6.setImage("https://i.etsystatic.com/27225411/r/il/4237cf/3475703071/il_1588xN.3475703071_jig3.jpg");
        stockingStufferRepository.save(stockingStuffer6);

        StockingStuffer stockingStuffer7 = new StockingStuffer();
        stockingStuffer7.setName("Homemade Crayon Shapes");
        stockingStuffer7.setDescription("Craft unique crayon shapes in holiday molds.");
        stockingStuffer7.setTag("children, kids");
        stockingStuffer7.setImage("https://i.etsystatic.com/24424497/r/il/fdaaa2/5025261630/il_1588xN.5025261630_6akv.jpg");
        stockingStufferRepository.save(stockingStuffer7);

        StockingStuffer stockingStuffer8 = new StockingStuffer();
        stockingStuffer8.setName("DIY Terrarium Ornament Kits");
        stockingStuffer8.setDescription("Assemble ornament kits with decorating materials.");
        stockingStuffer8.setTag("children, kids");
        stockingStuffer8.setImage("https://i.etsystatic.com/18729668/r/il/3c05a5/4306294926/il_1588xN.4306294926_h4oq.jpg");
        stockingStufferRepository.save(stockingStuffer8);

        StockingStuffer stockingStuffer9 = new StockingStuffer();
        stockingStuffer9.setName("DIY Bath Salts");
        stockingStuffer9.setDescription("Prepare bath salts with holiday scents in small jars.");
        stockingStuffer9.setTag("women");
        stockingStuffer9.setImage("https://i.etsystatic.com/31277148/r/il/e3b24c/3511953400/il_1588xN.3511953400_aqvp.jpg");
        stockingStufferRepository.save(stockingStuffer9);

        StockingStuffer stockingStuffer10 = new StockingStuffer();
        stockingStuffer10.setName("Eggnog Spice Blend");
        stockingStuffer10.setDescription("Create a blend of ground nutmeg, cinnamon, and a touch of allspice. Package it in small spice jars. It's perfect for spicing up eggnog, lattes, or desserts.");
        stockingStuffer10.setTag("men, women");
        stockingStuffer10.setImage("https://i.etsystatic.com/33446068/r/il/17e1d5/4759152760/il_1588xN.4759152760_su35.jpg");
        stockingStufferRepository.save(stockingStuffer10);

    }
}
