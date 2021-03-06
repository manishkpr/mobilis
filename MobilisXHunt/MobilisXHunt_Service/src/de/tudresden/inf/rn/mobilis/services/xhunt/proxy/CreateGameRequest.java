package de.tudresden.inf.rn.mobilis.services.xhunt.proxy;

import org.xmlpull.v1.XmlPullParser;

import de.tudresden.inf.rn.mobilis.xmpp.beans.XMPPBean;

public class CreateGameRequest extends XMPPBean {

	private int AreaId = Integer.MIN_VALUE;
	private String GameName = null;
	private String GamePassword = null;
	private int CountRounds = Integer.MIN_VALUE;
	private int MinPlayers = Integer.MIN_VALUE;
	private int MaxPlayers = Integer.MIN_VALUE;
	private int StartTimer = Integer.MIN_VALUE;
	private TicketsMrX TicketsMrX = new TicketsMrX();
	private TicketsAgents TicketsAgents = new TicketsAgents();


	public CreateGameRequest( int AreaId, String GameName, String GamePassword, int CountRounds, int MinPlayers, int MaxPlayers, int StartTimer, TicketsMrX TicketsMrX, TicketsAgents TicketsAgents ) {
		super();
		this.AreaId = AreaId;
		this.GameName = GameName;
		this.GamePassword = GamePassword;
		this.CountRounds = CountRounds;
		this.MinPlayers = MinPlayers;
		this.MaxPlayers = MaxPlayers;
		this.StartTimer = StartTimer;
		this.TicketsMrX = TicketsMrX;
		this.TicketsAgents = TicketsAgents;

		this.setType( XMPPBean.TYPE_SET );
	}

	public CreateGameRequest(){
		this.setType( XMPPBean.TYPE_SET );
	}


	@Override
	public void fromXML( XmlPullParser parser ) throws Exception {
		boolean done = false;
			
		do {
			switch (parser.getEventType()) {
			case XmlPullParser.START_TAG:
				String tagName = parser.getName();
				
				if (tagName.equals(getChildElement())) {
					parser.next();
				}
				else if (tagName.equals( "AreaId" ) ) {
					this.AreaId = Integer.parseInt( parser.nextText() );
				}
				else if (tagName.equals( "GameName" ) ) {
					this.GameName = parser.nextText();
				}
				else if (tagName.equals( "GamePassword" ) ) {
					this.GamePassword = parser.nextText();
				}
				else if (tagName.equals( "CountRounds" ) ) {
					this.CountRounds = Integer.parseInt( parser.nextText() );
				}
				else if (tagName.equals( "MinPlayers" ) ) {
					this.MinPlayers = Integer.parseInt( parser.nextText() );
				}
				else if (tagName.equals( "MaxPlayers" ) ) {
					this.MaxPlayers = Integer.parseInt( parser.nextText() );
				}
				else if (tagName.equals( "StartTimer" ) ) {
					this.StartTimer = Integer.parseInt( parser.nextText() );
				}
				else if (tagName.equals( TicketsMrX.CHILD_ELEMENT ) ) {
					this.TicketsMrX.fromXML( parser );
				}
				else if (tagName.equals( TicketsAgents.CHILD_ELEMENT ) ) {
					this.TicketsAgents.fromXML( parser );
				}
				else if (tagName.equals("error")) {
					parser = parseErrorAttributes(parser);
				}
				else
					parser.next();
				break;
			case XmlPullParser.END_TAG:
				if (parser.getName().equals(getChildElement()))
					done = true;
				else
					parser.next();
				break;
			case XmlPullParser.END_DOCUMENT:
				done = true;
				break;
			default:
				parser.next();
			}
		} while (!done);
	}

	public static final String CHILD_ELEMENT = "CreateGameRequest";

	@Override
	public String getChildElement() {
		return CHILD_ELEMENT;
	}

	public static final String NAMESPACE = "mobilisxhunt:iq:creategame";

	@Override
	public String getNamespace() {
		return NAMESPACE;
	}

	@Override
	public XMPPBean clone() {
		CreateGameRequest clone = new CreateGameRequest( AreaId, GameName, GamePassword, CountRounds, MinPlayers, MaxPlayers, StartTimer, TicketsMrX, TicketsAgents );
		clone.cloneBasicAttributes( clone );

		return clone;
	}

	@Override
	public String payloadToXML() {
		StringBuilder sb = new StringBuilder();

		sb.append( "<AreaId>" )
			.append( this.AreaId )
			.append( "</AreaId>" );

		sb.append( "<GameName>" )
			.append( this.GameName )
			.append( "</GameName>" );

		sb.append( "<GamePassword>" )
			.append( this.GamePassword )
			.append( "</GamePassword>" );

		sb.append( "<CountRounds>" )
			.append( this.CountRounds )
			.append( "</CountRounds>" );

		sb.append( "<MinPlayers>" )
			.append( this.MinPlayers )
			.append( "</MinPlayers>" );

		sb.append( "<MaxPlayers>" )
			.append( this.MaxPlayers )
			.append( "</MaxPlayers>" );

		sb.append( "<StartTimer>" )
			.append( this.StartTimer )
			.append( "</StartTimer>" );

		sb.append( "<" + this.TicketsMrX.getChildElement() + ">" )
			.append( this.TicketsMrX.toXML() )
			.append( "</" + this.TicketsMrX.getChildElement() + ">" );

		sb.append( "<" + this.TicketsAgents.getChildElement() + ">" )
			.append( this.TicketsAgents.toXML() )
			.append( "</" + this.TicketsAgents.getChildElement() + ">" );

		sb = appendErrorPayload(sb);

		return sb.toString();
	}


	public CreateGameRequest buildInputDataFault(String detailedErrorText){
		CreateGameRequest fault = ( CreateGameRequest )this.clone();

		fault.setTo( this.getFrom() );
    	fault.setId(this.getId());
		fault.setType( XMPPBean.TYPE_ERROR );
		fault.errorType = "modify";
		fault.errorCondition = "not-acceptable";
		fault.errorText = "Unaccepted data input.";

		if(null != detailedErrorText && detailedErrorText.length() > 0)
			fault.errorText += " Detail: " + detailedErrorText;
		
		return fault;
	}





	public int getAreaId() {
		return this.AreaId;
	}

	public void setAreaId( int AreaId ) {
		this.AreaId = AreaId;
	}

	public String getGameName() {
		return this.GameName;
	}

	public void setGameName( String GameName ) {
		this.GameName = GameName;
	}

	public String getGamePassword() {
		return this.GamePassword;
	}

	public void setGamePassword( String GamePassword ) {
		this.GamePassword = GamePassword;
	}

	public int getCountRounds() {
		return this.CountRounds;
	}

	public void setCountRounds( int CountRounds ) {
		this.CountRounds = CountRounds;
	}

	public int getMinPlayers() {
		return this.MinPlayers;
	}

	public void setMinPlayers( int MinPlayers ) {
		this.MinPlayers = MinPlayers;
	}

	public int getMaxPlayers() {
		return this.MaxPlayers;
	}

	public void setMaxPlayers( int MaxPlayers ) {
		this.MaxPlayers = MaxPlayers;
	}

	public int getStartTimer() {
		return this.StartTimer;
	}

	public void setStartTimer( int StartTimer ) {
		this.StartTimer = StartTimer;
	}

	public TicketsMrX getTicketsMrX() {
		return this.TicketsMrX;
	}

	public void setTicketsMrX( TicketsMrX TicketsMrX ) {
		this.TicketsMrX = TicketsMrX;
	}

	public TicketsAgents getTicketsAgents() {
		return this.TicketsAgents;
	}

	public void setTicketsAgents( TicketsAgents TicketsAgents ) {
		this.TicketsAgents = TicketsAgents;
	}

}