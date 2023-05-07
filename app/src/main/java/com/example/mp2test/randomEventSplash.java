package com.example.mp2test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class randomEventSplash extends AppCompatActivity {

    final static String MAP = "map";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_event_splash);
        if (getIntent().getBooleanExtra(monumentDescription.FINISHED, false)) finish();
        String title = getIntent().getStringExtra(mapPlaying.RND);
        Map map = (Map) getIntent().getSerializableExtra(mapPlaying.MAP);

        //Setup Text and buttons

        final TextView titleText = findViewById(R.id.randomEventSplashTitle);
        titleText.setText(title);
        final TextView splashText = findViewById(R.id.randomEventSplashText);

        if (title.equals("Kiss")) {
            splashText.setText("As you and your fellow travelers make your way along the dusty trail, you suddenly hear a rustling in the bushes. You cautiously approach, your hand resting on your trusty revolver, only to find that it's a young man with a kind smile and bright eyes.\n" +
                    "\n" +
                    "\"Excuse me, miss,\" he says, \"I couldn't help but notice you and your group passing by. My name is Jack, and I just wanted to thank you for the kindness you've shown to others on the trail.\"\n" +
                    "\n" +
                    "With that, he leans forward and plants a soft kiss on your cheek. You feel your face flush with warmth as he pulls back, his gaze steady on yours.\n" +
                    "\n" +
                    "\"May the road ahead bring you many more blessings,\" he says with a smile before disappearing back into the wilderness.\n" +
                    "\n" +
                    "As you continue on your journey, you feel a renewed sense of hope and courage, bolstered by the unexpected act of kindness from a stranger. The kiss serves as a reminder that even in the midst of hardship and uncertainty, there is still love and beauty to be found in the world.");
        }
        else if (title.equals("gold nugget")) {
            splashText.setText("As you're walking along the trail, you suddenly spot a glint of something shiny in the dirt. Curiosity piqued, you kneel down and begin to dig through the soil. To your amazement, you uncover a small but weighty gold nugget, gleaming brightly in the sun.\n" +
                    "\n" +
                    "Your heart races with excitement as you hold the nugget up to the light, marveling at its lustrous surface. This discovery could mean the difference between life and death for you and your fellow travelers. With this newfound wealth, you could buy the provisions you need to make it all the way to your destination.\n" +
                    "\n" +
                    "You carefully tuck the nugget into your pocket, feeling a sense of relief and triumph wash over you. It's been a long and arduous journey, but this small piece of treasure gives you renewed energy and hope for the road ahead. The nugget serves as a reminder that even in the harshest of circumstances, there are still moments of unexpected good fortune and joy to be found.");
        }
        else if (title.equals("nice native americans")) {
            splashText.setText("As you're traveling along the trail, you suddenly come upon a group of Native Americans, standing peacefully and looking at you with curious but welcoming expressions. You feel a sense of trepidation at first, unsure of how they might react to your presence. But as you approach them, you realize that they have no hostile intentions.\n" +
                    "\n" +
                    "They greet you warmly, offering you food and drink, and invite you to sit with them around a small fire. As you share stories and laughter, you feel a sense of kinship with these strangers who were once so foreign to you. They speak to you in their native tongue, and even though you don't understand everything they say, you feel a deep connection to their culture and way of life.\n" +
                    "\n" +
                    "Before you part ways, they offer you a small trinket as a gesture of friendship and goodwill. You accept it gratefully, feeling humbled by their generosity and hospitality.\n" +
                    "\n" +
                    "As you continue on your journey, you feel a renewed sense of hope and appreciation for the diversity of the world around you. This encounter with the Native Americans serves as a reminder that even in a time of great strife and conflict, there is still the potential for understanding and compassion between different cultures and peoples.");
        }
        else if (title.equals("bundle of food")) {
            splashText.setText("As you travel down the trail, you come across a bundle of food lying on the side of the road. It's a stroke of luck - you and your companions have been running low on supplies and the extra food could mean the difference between a full belly and an empty one.\n" +
                    "\n" +
                    "You approach the bundle cautiously, checking to make sure that it's safe and not booby-trapped. But as you inspect it, you realize that it's just a simple package of dried meat and vegetables, left behind by another traveler who must have had more than they needed.");
        }
        else if (title.equals("deserted wagon")) {
            splashText.setText("As you're traveling along the trail, you spot something in the distance: a lone wagon, abandoned and forgotten. Your heart sinks at the thought of the misfortune that must have befallen its previous occupants, but as you approach it, you realize that there is still some hope left.\n" +
                    "\n" +
                    "You find a few cans of food, still sealed and intact, tucked away in the wagon. It's not much, but it's more than you've had in days. You open one of the cans and take a tentative bite, savoring the taste of the salty meat and vegetables. It's a small blessing, but in this harsh and unforgiving wilderness, even the tiniest bit of sustenance can make a world of difference.\n" +
                    "\n" +
                    "As you gather the rest of the cans and prepare to continue on your journey, you feel a sense of gratitude for the small glimmers of hope that can still be found amidst the desolation and despair of the trail. The abandoned wagon serves as a reminder that even in the face of great adversity, there is still the potential for unexpected good fortune and resilience.\n");
        }
        else if (title.equals("miscounted food")) {
            splashText.setText("As you're rummaging through your supplies, you suddenly realize that you had more food than you initially thought. You must have miscounted when you last took inventory, because there are several cans and packages of food that you hadn't noticed before.\n" +
                    "\n" +
                    "You feel a surge of relief and gratitude as you realize that you and your fellow travelers will have enough to eat for a while longer. You open up one of the cans and savor the taste of the nourishing food, feeling the warmth and energy return to your body.\n" +
                    "\n" +
                    "As you continue on your journey, you feel a renewed sense of hope and determination. The discovery of the extra food serves as a reminder that sometimes the solution to a problem is closer than you think, and that it's important to take stock of your resources and keep a positive outlook even in the face of adversity.\n" +
                    "\n" +
                    "With this newfound sense of abundance, you press on with renewed vigor, knowing that even in the toughest of circumstances, you have the strength and resilience to overcome whatever challenges may lie ahead.");
        }
        else if (title.equals("house")) {
            splashText.setText("As you're making your way along the trail, you spot something in the distance: a small, quaint house, nestled amongst the trees. You feel a sense of curiosity and excitement, wondering who might live there and what secrets it might hold.\n" +
                    "\n" +
                    "As you approach the house, you notice that the door is ajar. You cautiously push it open and step inside, feeling a sense of awe at the simple but cozy furnishings. You see a pot of soup bubbling on the stove and a loaf of bread sitting on the table.\n" +
                    "\n" +
                    "Suddenly, you hear footsteps approaching, and a kindly-looking older woman appears in the doorway. She greets you with a warm smile, inviting you to sit down and share a meal with her.\n" +
                    "\n" +
                    "As you eat the soup and bread, you chat with the woman and learn about her life and her struggles. Despite her hardships, she remains cheerful and optimistic, and her positive outlook inspires you to keep going on your journey.\n" +
                    "\n" +
                    "Before you leave, the woman offers you a small gift as a token of her hospitality and friendship. You accept it gratefully, feeling a sense of connection and gratitude for this unexpected encounter.");
        }
        else if (title.equals("wandering oxen")) {
            splashText.setText("As you're making your way along the trail, you spot something moving in the distance. As you draw closer, you realize that it's an ox, wandering alone and seemingly lost.\n" +
                    "\n" +
                    "You approach the animal cautiously, but it seems friendly and docile, and you're able to lead it back to your wagon without much trouble. As you inspect it more closely, you realize that it's a healthy and strong animal, well-suited for the rigors of the trail.\n" +
                    "\n" +
                    "You feel a sense of relief and gratitude as you realize that this extra ox will make your journey much easier. With an extra animal to help pull your wagon, you'll be able to cover more ground and carry more supplies. You pat the ox on the head, feeling a sense of kinship and appreciation for this unexpected stroke of good luck.\n" +
                    "\n" +
                    "As you continue on your journey, you feel a renewed sense of optimism and determination. The extra ox serves as a reminder that sometimes help can come from the most unexpected sources, and that even in the toughest of circumstances, there is still the potential for good fortune and resilience.\n" +
                    "\n" +
                    "With this newfound sense of confidence, you set off down the trail once again, grateful for the strength and companionship of your new animal friend.");
        }
        else if (title.equals("good sleep")) {
            splashText.setText("As you're making your way along the trail, you spot something moving in the distance. As you draw closer, you realize that it's an ox, wandering alone and seemingly lost.\n" +
                    "\n" +
                    "You approach the animal cautiously, but it seems friendly and docile, and you're able to lead it back to your wagon without much trouble. As you inspect it more closely, you realize that it's a healthy and strong animal, well-suited for the rigors of the trail.\n" +
                    "\n" +
                    "You feel a sense of relief and gratitude as you realize that this extra ox will make your journey much easier. With an extra animal to help pull your wagon, you'll be able to cover more ground and carry more supplies. You pat the ox on the head, feeling a sense of kinship and appreciation for this unexpected stroke of good luck.\n" +
                    "\n" +
                    "As you continue on your journey, you feel a renewed sense of optimism and determination. The extra ox serves as a reminder that sometimes help can come from the most unexpected sources, and that even in the toughest of circumstances, there is still the potential for good fortune and resilience.\n" +
                    "\n" +
                    "With this newfound sense of confidence, you set off down the trail once again, grateful for the strength and companionship of your new animal friend.");
        }
        else if (title.equals("Alex Fimel")) {
            splashText.setText("As you travel down the trail, you notice a figure in the distance, walking towards you. As the figure approaches, you realize that it's a fellow traveler, a man named Alex Fimel.\n" +
                    "\n" +
                    "Alex greets you warmly, introducing himself as a fellow pioneer on the trail. He tells you that he's been following your progress and admires your determination and resilience. You feel a sense of surprise and gratitude, not quite sure how this stranger knows so much about your journey.");
        }
        else if (title.equals("animals go to the food")) {
            splashText.setText("As you make your way down the trail, you notice a commotion up ahead. As you get closer, you realize with horror that your oxen have broken into the food supply and are devouring the precious provisions.\n" +
                    "\n" +
                    "You rush forward, trying to scare them away, but it's too late. The damage has been done. Sacks of flour and sugar lay ripped open on the ground, and your once-plentiful stores have been reduced to a mere fraction of what they were.");
        }
        else if (title.equals("broken wheel")) {
            splashText.setText("As you're making your way down the trail, you hear a sudden, jarring noise. You quickly realize that one of your wagon's wheel axles has broken, leaving the wheel partially detached and wobbling precariously.\n" +
                    "\n" +
                    "You feel a sense of panic and frustration welling up inside you. The axle is a crucial component of your wagon, and without it, your progress will come to a grinding halt.");
        }
        else if (title.equals("aggressive native americans")) {
            splashText.setText("angry Native Americans. They brandish weapons and shout at you in a language you don't understand.\n" +
                    "\n" +
                    "You quickly realize that they're angry that you've trespassed on their land. Despite your attempts to explain that you're just passing through, they seem unwilling to listen.");
        }
        else if (title.equals("thief")) {
            splashText.setText("As you continue along the trail, you suddenly realize that one of your valuable items is missing. You search frantically through your belongings, but it's nowhere to be found.\n" +
                    "\n" +
                    "After a moment of panic, you begin to consider the possibility that someone may have stolen it. You feel a sense of anger and betrayal, wondering how someone could do such a thing.\n" +
                    "\n" +
                    "As you look around, you notice that one of your fellow travelers seems to be acting suspiciously. You confront them, demanding to know if they took your item. They deny it, but their nervousness only fuels your suspicion.\n" +
                    "\n" +
                    "You feel a sense of frustration and helplessness as you realize that you may never know who took your item. You know that this loss could set you back significantly and put your journey in jeopardy.");
        }
        else if (title.equals("bad shortcut")) {
            splashText.setText("As you travel down the trail, you come across a fellow traveler who offers to give you directions. Grateful for the help, you eagerly listen to their advice and set off in the direction they've indicated.\n" +
                    "\n" +
                    "As you journey on, however, you begin to realize that something isn't quite right. The terrain becomes rougher, the weather more unpredictable, and your progress slows significantly.\n" +
                    "\n" +
                    "You soon come to the painful realization that the traveler who gave you directions was mistaken or perhaps intentionally misleading. You feel a sense of frustration and anger, wondering how you could have been so trusting. \n" +
                    "You loose a few days of progress.");
        }
        else if (title.equals("rainy day")) {
            splashText.setText("As you wake up to begin another day of travel on the trail, you're dismayed to see that it's raining heavily. You know that traveling in these conditions will be difficult and could cause setbacks for your journey.");
        }
        else if (title.equals("broken leg")) {
            splashText.setText("As you travel down the trail, disaster strikes as you suddenly lose your footing and fall, breaking your leg. You feel a sharp pain shoot through your body as you try to get back up, but find that you're unable to move.\n" +
                    "\n" +
                    "You feel a sense of panic and helplessness as you realize the gravity of your situation. You know that a broken leg could be a life-threatening injury on the trail, and that your journey is now in jeopardy.\n" +
                    "\n" +
                    "As your travel companions come to your aid, you feel a mix of gratitude and embarrassment at your predicament. You know that your injury will cause setbacks for your group, and that they'll need to take extra measures to ensure your safety and well-being.\n" +
                    "\n" +
                    "Despite the pain and discomfort, you try to remain positive and determined. You know that you must endure the pain and focus on your recovery if you're to have any hope of reaching your destination.");
        }
        else if (title.equals("tired oxen")) {
            splashText.setText("As you travel down the trail, you notice that one of your oxen is lagging behind and seems to be struggling to keep up with the rest of the team. You feel a sense of unease as you realize that a tired or injured oxen could cause significant setbacks for your journey.\n" +
                    "\n" +
                    "As you inspect the tired oxen, you see that it's covered in sweat and appears to be fatigued. You know that it's not safe to push the animal too hard, as it could lead to further injury or even death.\n" +
                    "\n" +
                    "You and your companions weigh your options, and eventually decide to stop for the day and let the oxen rest. Although you're frustrated at the delay, you know that it's the responsible thing to do.");
        }
        else if (title.equals("misplaced food")) {
            splashText.setText("As you travel down the trail, you notice that your food supply is running low. You begin to worry about how you'll make it to your destination without enough sustenance.\n" +
                    "\n" +
                    "As you and your companions search through your belongings, you realize with a sinking feeling that some of your food is missing. You search high and low, but it's nowhere to be found.\n" +
                    "\n" +
                    "You feel frustrated and angry with yourself for misplacing such a critical resource. You know that without enough food, you and your companions will struggle to make it through the rest of the journey.");
        }
        else if (title.equals("Volcano")) {
            splashText.setText("As you travel down the trail, you come across a stunning sight - a hot geyser spewing steam and boiling water high into the air. You feel a sense of awe and wonder as you watch the natural phenomenon in action.\n" +
                    "\n" +
                    "However, as you get closer to the geyser, you realize that it poses a serious danger. The water is scalding hot and the steam can cause burns and respiratory problems. You and your companions need to be careful to avoid getting too close.\n" +
                    "\n" +
                    "As you watch the geyser, you notice that it has a regular pattern - it erupts with hot water and steam every few minutes, before settling down again. You realize that if you time your movements carefully, you may be able to cross the area safely during the calm periods.\n" +
                    "\n" +
                    "You wait for the geyser to erupt one more time, then make a dash for it as soon as it settles down. You move quickly, keeping your eyes on the geyser and listening for any signs of a new eruption.\n" +
                    "\n" +
                    "But as you cross the geyser, you feel a jolt and realize that you've dropped one of your personal belongings in the rush. You turn to look back at the geyser, but it's already spewing hot water and steam again. You know that it's too dangerous to go back for your belongings now.");
        }
        else {
            splashText.setText("Nothing in particular happened today...");
        }

        final Button cont = findViewById(R.id.contButton);
        cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}