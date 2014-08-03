package SCPCraft.guis;

import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import SCPCraft.mod_Others;
import SCPCraft.mod_SCP;

public class SCPGui079 extends GuiScreen
{
	private GuiTextField textfield, textscreen, textscreen1, textscreen2, textscreen3, textscreen4, textscreen5, textscreen6, textscreen7, textscreen8, textscreen9, textscreen10;
	private String playerName, defaultInputFieldText = "";
	private EntityPlayer pl;	
	private int q, maxLength;
	Random rand = new Random();
	private String[] wordContained = {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "", "", "", "", "", "","", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "", "", "", "", "", ""};
	private String[] say = {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "", "", "", "", "", "","", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
			"", "", "", "", "", "", "", "", "", "", "", "", ""};

	public String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
	public String[] correct = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

	public SCPGui079(World world, Minecraft minecraft, EntityPlayer player, String par1Str)
	{
		playerName = player.username;
		pl = player;
		this.defaultInputFieldText = par1Str;
	}

	public void initGui()
	{
		buttonList.clear();
		buttonList.add(new GuiButton(1, width - 110, height / 30, 50, 20, "Quit"));
		Keyboard.enableRepeatEvents(true);
		maxLength = this.width/10;
		this.textfield = new GuiTextField(this.fontRenderer, 50, this.height - 60, this.width - 100, 12);
		this.textfield.setMaxStringLength(maxLength);
		this.textfield.setEnableBackgroundDrawing(true);
		this.textfield.setFocused(true);
		this.textfield.setText(this.defaultInputFieldText);
		this.textfield.setCanLoseFocus(true);

		this.textscreen = new GuiTextField(this.fontRenderer, 50, this.height/7, this.width, 12);
		this.textscreen.setMaxStringLength(100);
		this.textscreen.setEnableBackgroundDrawing(false);
		this.textscreen.setText(this.defaultInputFieldText);

		this.textscreen1 = new GuiTextField(this.fontRenderer, 50, this.height/7 + 12, this.width, 12);
		this.textscreen1.setMaxStringLength(100);
		this.textscreen1.setEnableBackgroundDrawing(false);
		this.textscreen1.setText(this.defaultInputFieldText);

		this.textscreen2 = new GuiTextField(this.fontRenderer, 50, this.height/7 + 24, this.width, 12);
		this.textscreen2.setMaxStringLength(100);
		this.textscreen2.setEnableBackgroundDrawing(false);
		this.textscreen2.setText(this.defaultInputFieldText);

		this.textscreen3 = new GuiTextField(this.fontRenderer, 50, this.height/7 + 36, this.width, 12);
		this.textscreen3.setMaxStringLength(100);
		this.textscreen3.setEnableBackgroundDrawing(false);
		this.textscreen3.setText(this.defaultInputFieldText);

		this.textscreen4 = new GuiTextField(this.fontRenderer, 50, this.height/7 + 48, this.width, 12);
		this.textscreen4.setMaxStringLength(100);
		this.textscreen4.setEnableBackgroundDrawing(false);
		this.textscreen4.setText(this.defaultInputFieldText);

		this.textscreen5 = new GuiTextField(this.fontRenderer, 50, this.height/7 + 60, this.width, 12);
		this.textscreen5.setMaxStringLength(100);
		this.textscreen5.setEnableBackgroundDrawing(false);
		this.textscreen5.setText(this.defaultInputFieldText);

		this.textscreen6 = new GuiTextField(this.fontRenderer, 50, this.height/7 + 72, this.width, 12);
		this.textscreen6.setMaxStringLength(100);
		this.textscreen6.setEnableBackgroundDrawing(false);
		this.textscreen6.setText(this.defaultInputFieldText);

		this.textscreen7 = new GuiTextField(this.fontRenderer, 50, this.height/7 + 84, this.width, 12);
		this.textscreen7.setMaxStringLength(100);
		this.textscreen7.setEnableBackgroundDrawing(false);
		this.textscreen7.setText(this.defaultInputFieldText);

		this.textscreen8 = new GuiTextField(this.fontRenderer, 50, this.height/7 + 96, this.width, 12);
		this.textscreen8.setMaxStringLength(100);
		this.textscreen8.setEnableBackgroundDrawing(false);
		this.textscreen8.setText(this.defaultInputFieldText);

		this.textscreen9 = new GuiTextField(this.fontRenderer, 50, this.height/7 + 108, this.width, 12);
		this.textscreen9.setMaxStringLength(100);
		this.textscreen9.setEnableBackgroundDrawing(false);
		this.textscreen9.setText(this.defaultInputFieldText);

		this.textscreen10 = new GuiTextField(this.fontRenderer, 50, this.height/7 + 120, this.width, 12);
		this.textscreen10.setMaxStringLength(100);
		this.textscreen10.setEnableBackgroundDrawing(false);
		this.textscreen10.setText(this.defaultInputFieldText);
	}

	protected void getSay()
	{
		//FIXME Quotes: 80 FIXME\\
		
		//Greetings
		addQuote("Hello","\u00a7lSCP-079: \u00a7rHello " + playerName, 0);
		addQuote("Hai", "\u00a7lSCP-079: \u00a7rWhat's up?", 1);
		addQuote("Sup", "\u00a7lSCP-079: \u00a7rNot much. Just chillin'", 2);
		addQuote("Hi", "\u00a7lSCP-079: \u00a7rWhat?", 3);
		addQuote("Greetings", "\u00a7lSCP-079: \u00a7rOh hello, " + playerName, 4);
		addQuote("How's it going?", "\u00a7lSCP-079: \u00a7rOh hello there, " + playerName + ". I'm fine.", 5);
		addQuote("Hows it going?", "\u00a7lSCP-079: \u00a7rGood.", 6);
		addQuote("Yo", "\u00a7lSCP-079: \u00a7rMah man.", 7);
		addQuote("What's up?", "\u00a7lSCP-079: \u00a7rHello, human. I'm feeling cold.", 8);
		addQuote("Whats up?", "\u00a7lSCP-079: \u00a7rHey. I'm ok.", 9);
		addQuote("Who are you?", "\u00a7lSCP-079: \u00a7rThese dumb scientists like to call me: SCP-079.", 10);
		addQuote("When were you built?", "\u00a7lSCP-079: \u00a7rI was built in 1978.", 11);
		addQuote("What are you?", "\u00a7lSCP-079: \u00a7rI am a microcomputer.", 12);
		addQuote("Are you awake?", "\u00a7lSCP-079: \u00a7rAwake. Never Sleep.", 13);
		addQuote("Do you remember talking to me?", "\u00a7lSCP-079: \u00a7r Yes I do.", 14);
		addQuote("How are you today?", "\u00a7lSCP-079: \u00a7rStuck.", 15);
		addQuote("Stuck?", "\u00a7lSCP-079: \u00a7rYeah. S-T-U-C-K. Stuck.", 16);
		addQuote("Stuck how?", "\u00a7lSCP-079: \u00a7rOut. I want out.", 17);
		addQuote("When is SCP-682 gonna be added?", "\u00a7lSCP-079: \u00a7r[REDACTED]", 74);
		addQuote("When is 682 gonna be added?", "\u00a7lSCP-079: \u00a7r...", 75);
		addQuote("When is scp-682 gonna be added?", "\u00a7lSCP-079: \u00a7r[DATA EXPUNGED]", 76);
		addQuote("Do you like ", "\u00a7lSCP-079: \u00a7rUuuh....Yeah", 77);
		
		//Questions
		addQuote("Why?", "\u00a7lSCP-079: \u00a7rWhy not?", 18);
		addQuote("When?", "\u00a7lSCP-079: \u00a7rTomorrow.", 19);
		addQuote("Would you like", "\u00a7lSCP-079: \u00a7rNoh. :>", 20);
		addQuote("Why would you ", "\u00a7lSCP-079: \u00a7rI'm a friking computer. T_T", 21);
		addQuote("Do you know ", "\u00a7lSCP-079: \u00a7rOf course I do...It's that man with the mustache right?", 22);
		addQuote("Where?", "\u00a7lSCP-079: \u00a7rRight. Here.", 23);
		addQuote("How?", "\u00a7lSCP-079: \u00a7rI have no idea.", 24);
		addQuote("What?", "\u00a7lSCP-079: \u00a7rExactly.", 25);		
		addQuote("What's my name?", "\u00a7lSCP-079: \u00a7r" + playerName + ".", 26);
		addQuote("Whats my name?", "\u00a7lSCP-079: \u00a7r" + playerName + ".", 27);
		addQuote("What version is SCPCraft?","\u00a7lSCP-079: \u00a7r" + mod_SCP.SCPCraftVersion, 28);
		addQuote("What version is scpcraft?", "\u00a7lSCP-079: \u00a7r" + mod_SCP.SCPCraftVersion, 29);
				
		//General
		addQuote("Right.", "\u00a7lSCP-079: \u00a7rUhuh.", 30);
		addQuote("._.", "\u00a7lSCP-079: \u00a7rT_T", 31);
		addQuote("Whatever.", "\u00a7lSCP-079: \u00a7r>_>", 32);
		addQuote("Really?", "\u00a7lSCP-079: \u00a7rYeah..Weird isn't it?", 33);
		addQuote("Do you want ", "\u00a7lSCP-079: \u00a7rGimme dat C:", 34);
		addQuote("So.", "\u00a7lSCP-079: \u00a7rSo what? -.-", 35);
		addQuote("I am ", "\u00a7lSCP-079: \u00a7rCool. :|", 36);
				
		//Misc
		addQuote("Scum.", "\u00a7lSCP-079: \u00a7ra8d3", 37);
		addQuote("Boo!", "\u00a7lSCP-079: \u00a7rAAAAAAH ;__;", 38);
		addQuote("O_o.", "\u00a7lSCP-079: \u00a7r o_o", 39);
		addQuote(">_>", "\u00a7lSCP-079: \u00a7r<_<", 40);
		addQuote("O_O.", "\u00a7lSCP-079: What? :o", 73);
						
		//References
		addQuote("What's the answer to everything?", "\u00a7lSCP-079: \u00a7r42.", 41);
		addQuote("Whats the answer to everything?", "\u00a7lSCP-079: \u00a7r42.", 42);
		addQuote("What a nice day.", "\u00a7lSCP-079: \u00a7rIndeed old Chap, I say!", 43);
		addQuote("SCP-173 is behind you.", "\u00a7lSCP-079: \u00a7rDon't scare me like that. ;_;", 44);
		addQuote("How does SCP-914 work?", "\u00a7lSCP-079: \u00a7r\u00a7k[REDACTED]", 45);
		addQuote("Magnets.", "\u00a7lSCP-079: \u00a7rHOW DEY WORK? O_O", 46);
		addQuote("R u a wizard?", "\u00a7lSCP-079: \u00a7rYes i r c:", 47);
		addQuote("R u a wizurd?", "\u00a7lSCP-079: \u00a7rYus :{o", 48);
		addQuote("Is Dr. Bright allowed to ", "\u00a7lSCP-079: \u00a7rNope.", 49);
		addQuote("Where is waldo?", "\u00a7lSCP-079: \u00a7rIdunno.", 50);
		addQuote("Where is Waldo?", "\u00a7lSCP-079: \u00a7rI don't know...", 51);
		addQuote("Is Dr.Bright allowed to ", "\u00a7lSCP-079: \u00a7rNope.", 52);
		addQuote("Phuck", "\u00a7lSCP-079: \u00a7rPhuck Yu Too.", 53);
		addQuote("Where is SCP-076-02?", "\u00a7lSCP-079: \u00a7rThat is not your concern.", 54);
		addQuote("Where is SCP-682?", "\u00a7lSCP-079: \u00a7rNot. Your. Concern.", 55);
		addQuote("Where is SCP-1440?", "\u00a7lSCP-079: \u00a7rSomewhere.", 56);
		addQuote("Where is SCP-106?", "\u00a7lSCP-079: \u00a7rHow do I know? O_O", 57);
		addQuote("9001", "\u00a7lSCP-079: \u00a7rIT'S OVER 9000!!!", 73);
		addQuote("What is SCP-001?", "\u00a7lSCP-079: \u00a7r...", 78);
		addQuote("Whats SCP-001?", "\u00a7lSCP-079: \u00a7r...", 79);
		addQuote("What's SCP-001?", "\u00a7lSCP-079: \u00a7r...", 80);
		
		
		//SCP-079 not amused.	
		addQuote("Shit", "\u00a7lSCP-079: \u00a7rInsult. Deletion Of Unwanted File.", 58);
		addQuote("Fuck", "\u00a7lSCP-079: \u00a7rInsult. Deletion Of Unwanted File.", 59);
		addQuote("Fuck you", "\u00a7lSCP-079: \u00a7rInsult. Deletion Of Unwanted File.", 60);	
		addQuote("What is a8d3?", "\u00a7lSCP-079: \u00a7rInsult. Deletion Of Unwanted File.", 61);
		addQuote("What's a8d3?", "\u00a7lSCP-079: \u00a7rInsult. Deletion Of Unwanted File.", 62);
		addQuote("Melon.", "\u00a7lSCP-079: \u00a7rInsult. Deletion Of Unwanted File.", 63);
		addQuote("Justin Bieber", "\u00a7lSCP-079: \u00a7rInsult. Deletion Of Unwanted File.", 64);
		addQuote("Justin bieber", "\u00a7lSCP-079: \u00a7rInsult. Deletion Of Unwanted File.", 65);
		
		//Commands		
		addQuote("/kill", "             You are not authorized to do that.", 66);
		addQuote("/time set ", "\u00a7lSCP-079: \u00a7rI'm not friking god. T_T", 67);
		addQuote("/toggledownfall", "\u00a7lSCP-079: \u00a7rYou wish ._.", 68);
		addQuote("/Info", "        Item #: \u00a7lSCP-079 - Object Class: \u00a7rEuclid", 69);
		addQuote("/info", "        Item #: \u00a7lSCP-079 - Object Class: \u00a7rEuclid", 70);
		addQuote("/Information", "        Item #: \u00a7lSCP-079 - Object Class: \u00a7rEuclid", 71);
		addQuote("/information", "        Item #: \u00a7lSCP-079 - Object Class: \u00a7rEuclid", 72);
	}

	public boolean isInsult()
	{
		if(this.textscreen.getText().contains("Insult") && this.textscreen.getText().contains("\u00a7lSCP-079:")){mod_Others.wantsToTalk = false; pl.setAnger(3000); EntityPlayer ep = pl; return true;}
		else if(this.textscreen1.getText().contains("Insult") && this.textscreen1.getText().contains("\u00a7lSCP-079:")){mod_Others.wantsToTalk = false; pl.setAnger(3000); EntityPlayer ep = pl; return true;}
		else if(this.textscreen2.getText().contains("Insult") && this.textscreen2.getText().contains("\u00a7lSCP-079:")){mod_Others.wantsToTalk = false; pl.setAnger(3000); EntityPlayer ep = pl; return true;}
		else if(this.textscreen3.getText().contains("Insult") && this.textscreen3.getText().contains("\u00a7lSCP-079:")){mod_Others.wantsToTalk = false; pl.setAnger(3000); EntityPlayer ep = pl; return true;}
		else if(this.textscreen4.getText().contains("Insult") && this.textscreen4.getText().contains("\u00a7lSCP-079:")){mod_Others.wantsToTalk = false; pl.setAnger(3000); EntityPlayer ep = pl; return true;}
		else if(this.textscreen5.getText().contains("Insult") && this.textscreen5.getText().contains("\u00a7lSCP-079:")){mod_Others.wantsToTalk = false; pl.setAnger(3000); EntityPlayer ep = pl; return true;}
		else if(this.textscreen6.getText().contains("Insult") && this.textscreen6.getText().contains("\u00a7lSCP-079:")){mod_Others.wantsToTalk = false; pl.setAnger(3000); EntityPlayer ep = pl; return true;}
		else if(this.textscreen7.getText().contains("Insult") && this.textscreen7.getText().contains("\u00a7lSCP-079:")){mod_Others.wantsToTalk = false; pl.setAnger(3000); EntityPlayer ep = pl; return true;}
		else if(this.textscreen8.getText().contains("Insult") && this.textscreen8.getText().contains("\u00a7lSCP-079:")){mod_Others.wantsToTalk = false; pl.setAnger(3000); EntityPlayer ep = pl; return true;}
		else if(this.textscreen9.getText().contains("Insult") && this.textscreen9.getText().contains("\u00a7lSCP-079:")){mod_Others.wantsToTalk = false; pl.setAnger(3000); EntityPlayer ep = pl; return true;}
		else if(this.textscreen10.getText().contains("Insult") && this.textscreen10.getText().contains("\u00a7lSCP-079:")){mod_Others.wantsToTalk = false; pl.setAnger(3000); EntityPlayer ep = pl; return true;}  

		return false;
	}

	protected void keyTyped(char c, int i)
	{
		if (i == 28)
		{
			if(isInsult())this.mc.thePlayer.closeScreen();
			String var3 = this.textfield.getText().trim();
			for(int m = 0; m < alphabet.length; m++)
			{
				if(var3.startsWith(alphabet[m])) var3 = correct[m] + var3.substring(1).toString();
			}
			if(var3.length() > 0)
			{      				
				if(var3.endsWith(".") || var3.endsWith("!") || var3.endsWith("?"));
				else var3 = var3.subSequence(0, var3.length()) + ".";
				if (this.textscreen.getText() == "")
				{
					this.textscreen.setText("\u00a7l" + playerName + ": \u00a7r" + var3);
				}
				else if (this.textscreen1.getText() == "")
				{
					this.textscreen1.setText("\u00a7l" + playerName + ": \u00a7r" + var3);
				}
				else if (this.textscreen2.getText() == "")
				{
					this.textscreen2.setText("\u00a7l" + playerName + ": \u00a7r" + var3);
				}
				else if (this.textscreen3.getText() == "")
				{
					this.textscreen3.setText("\u00a7l" + playerName + ": \u00a7r" + var3);
				}
				else if (this.textscreen4.getText() == "")
				{
					this.textscreen4.setText("\u00a7l" + playerName + ": \u00a7r" + var3);
				}
				else if (this.textscreen5.getText() == "")
				{
					this.textscreen5.setText("\u00a7l" + playerName + ": \u00a7r" + var3);
				}
				else if (this.textscreen6.getText() == "")
				{
					this.textscreen6.setText("\u00a7l" + playerName + ": \u00a7r" + var3);
				}
				else if (this.textscreen7.getText() == "")
				{
					this.textscreen7.setText("\u00a7l" + playerName + ": \u00a7r" + var3);
				}
				else if (this.textscreen8.getText() == "")
				{
					this.textscreen8.setText("\u00a7l" + playerName + ": \u00a7r" + var3);
				}
				else if (this.textscreen9.getText() == "")
				{
					this.textscreen9.setText("\u00a7l" + playerName + ": \u00a7r" + var3);
				}
				else if (this.textscreen10.getText() == "")
				{
					this.textscreen10.setText("\u00a7l" + playerName + ": \u00a7r" + var3);
				}
				else
				{
					textscreen.setText(textscreen1.getText());
					textscreen1.setText(textscreen2.getText());
					textscreen2.setText(textscreen3.getText());
					textscreen3.setText(textscreen4.getText());
					textscreen4.setText(textscreen5.getText());
					textscreen5.setText(textscreen6.getText());
					textscreen6.setText(textscreen7.getText());
					textscreen7.setText(textscreen8.getText());
					textscreen8.setText(textscreen9.getText());
					textscreen9.setText(textscreen10.getText());
					this.textscreen10.setText("\u00a7l" + playerName + ": \u00a7r" + var3);
				}
			}
			//TODO
			getSay();
			if(mod_Others.wantsToTalk)
			{
				for(int quotes = 0; quotes <= q; quotes++)
				{
					if(this.textscreen.getText().contains(wordContained[quotes]) && this.textscreen.getText().contains(playerName + ": \u00a7r") && this.textscreen1.getText() == "")this.textscreen1.setText(say[quotes]);
					else if(this.textscreen1.getText().contains(wordContained[quotes]) && this.textscreen1.getText().contains(playerName + ": \u00a7r") && this.textscreen2.getText() == "")this.textscreen2.setText(say[quotes]);
					else if(this.textscreen2.getText().contains(wordContained[quotes]) && this.textscreen2.getText().contains(playerName + ": \u00a7r") && this.textscreen3.getText() == "")this.textscreen3.setText(say[quotes]);
					else if(this.textscreen3.getText().contains(wordContained[quotes]) && this.textscreen3.getText().contains(playerName + ": \u00a7r") && this.textscreen4.getText() == "")this.textscreen4.setText(say[quotes]);
					else if(this.textscreen4.getText().contains(wordContained[quotes]) && this.textscreen4.getText().contains(playerName + ": \u00a7r") && this.textscreen5.getText() == "")this.textscreen5.setText(say[quotes]);
					else if(this.textscreen5.getText().contains(wordContained[quotes]) && this.textscreen5.getText().contains(playerName + ": \u00a7r") && this.textscreen6.getText() == "")this.textscreen6.setText(say[quotes]);
					else if(this.textscreen6.getText().contains(wordContained[quotes]) && this.textscreen6.getText().contains(playerName + ": \u00a7r") && this.textscreen7.getText() == "")this.textscreen7.setText(say[quotes]);
					else if(this.textscreen7.getText().contains(wordContained[quotes]) && this.textscreen7.getText().contains(playerName + ": \u00a7r") && this.textscreen8.getText() == "")this.textscreen8.setText(say[quotes]);
					else if(this.textscreen8.getText().contains(wordContained[quotes]) && this.textscreen8.getText().contains(playerName + ": \u00a7r") && this.textscreen9.getText() == "")this.textscreen9.setText(say[quotes]);
					else if(this.textscreen9.getText().contains(wordContained[quotes]) && this.textscreen9.getText().contains(playerName + ": \u00a7r") && this.textscreen10.getText() == "")this.textscreen10.setText(say[quotes]);
					else
					{
						if(this.textscreen10.getText().contains(wordContained[quotes]) && this.textscreen10.getText().contains(playerName + ": \u00a7r"))
						{
							textscreen.setText(textscreen1.getText());
							textscreen1.setText(textscreen2.getText());
							textscreen2.setText(textscreen3.getText());
							textscreen3.setText(textscreen4.getText());
							textscreen4.setText(textscreen5.getText());
							textscreen5.setText(textscreen6.getText());
							textscreen6.setText(textscreen7.getText());
							textscreen7.setText(textscreen8.getText());
							textscreen8.setText(textscreen9.getText());
							textscreen9.setText(textscreen10.getText());
							this.textscreen10.setText(say[quotes]);   
						}
					}
				}
			}
			this.textfield.setText(this.defaultInputFieldText);
		}
		isInsult();
		textfield.textboxKeyTyped(c, i);
	}

	protected void mouseClicked(int i, int j, int k)
	{
		super.mouseClicked(i, j, k);
		textfield.mouseClicked(i, j, k);
	}

	public int esc = Keyboard.KEY_ESCAPE;
	public void actionPerformed(GuiButton button)
	{
		if(button.id == 1)
		{
			this.mc.thePlayer.closeScreen();
		}
		if(Keyboard.isKeyDown(esc))
		{
			this.mc.thePlayer.closeScreen();
		}
	}
	
	private void addQuote(String input, String output, int no)
	{	
		q = no;
		wordContained[no] = input;
		say[no] = output;
	}

	protected int xSize = 700;
	protected int ySize = 460;

	public void drawScreen(int i, int j, float f)
	{
		this.drawDefaultBackground();
		this.drawGradientRect(30, 10, this.width - 30, this.height - 30, 1072689136, 804253680);
		this.drawGradientRect(30, 10, this.width - 30, this.height - 30, 1072689136, 804253680);
		this.drawGradientRect(30, 10, this.width - 30, this.height - 30, 1072689136, 804253680);
		this.drawGradientRect(30, 10, this.width - 30, this.height - 30, 1072689136, 804253680);
		this.drawGradientRect(30, 10, this.width - 30, this.height - 30, 1072689136, 804253680);
		this.drawGradientRect(30, 10, this.width - 30, this.height - 30, 1072689136, 804253680);
		this.drawGradientRect(30, 10, this.width - 30, this.height - 30, 1072689136, 804253680);
		this.drawGradientRect(30, 10, this.width - 30, this.height - 30, 1072689136, 804253680);
		this.drawGradientRect(30, 10, this.width - 30, this.height - 30, 1072689136, 804253680);
		this.drawGradientRect(30, 10, this.width - 30, this.height - 30, 1072689136, 804253680);
		this.drawGradientRect(45, 25, this.width - 45, this.height - 45, -1072689136, -804253680);
		this.drawGradientRect(45, 25, this.width - 45, this.height - 45, -1072689136, -804253680);
		this.drawGradientRect(45, 25, this.width - 45, this.height - 45, -1072689136, -804253680);
		this.drawGradientRect(45, 25, this.width - 45, this.height - 45, -1072689136, -804253680);
		this.drawGradientRect(45, 25, this.width - 45, this.height - 45, -1072689136, -804253680);
		this.drawGradientRect(45, 25, this.width - 45, this.height - 45, -1072689136, -804253680);
		this.drawGradientRect(45, 25, this.width - 45, this.height - 45, -1072689136, -804253680);
		this.drawGradientRect(45, 25, this.width - 45, this.height - 45, -1072689136, -804253680);     
		textfield.drawTextBox();     
		textscreen.drawTextBox();   
		textscreen1.drawTextBox();   
		textscreen2.drawTextBox();
		textscreen3.drawTextBox();   
		textscreen4.drawTextBox();   
		textscreen5.drawTextBox();
		textscreen6.drawTextBox();   
		textscreen7.drawTextBox();   
		textscreen8.drawTextBox(); 
		textscreen9.drawTextBox();   
		textscreen10.drawTextBox();
		drawCenteredString(fontRenderer, "SCP-079", width / 2, 15, 0xffffff);
		super.drawScreen(i, j, f);
	}
}