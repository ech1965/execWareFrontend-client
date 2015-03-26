package de.uniulm.omi.executionware.entities;

import de.uniulm.omi.executionware.entities.internal.AbstractEntity;
import de.uniulm.omi.executionware.entities.internal.Link;
import de.uniulm.omi.executionware.entities.internal.Path;

import javax.annotation.Nullable;
import java.util.List;

import java.util.Base64;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by ec on 23/03/15.
 */
@Path("model")
public class PaasageModel extends AbstractEntity {

    /**
     * A common method for all enums since they can't have another base class
     *
     * @param <T>    Enum type
     * @param c      enum type. All enums must be all caps.
     * @param string case insensitive
     * @return corresponding enum, or null
     */
    private static <T extends Enum<T>> T getEnumFromString(Class<T> c, String string) {
        if (c != null && string != null) {
            return Enum.valueOf(c, string.trim().toUpperCase());
        }
        return null;
    }

    public enum State {
        NEW, UNCHANGED, CREATED, UPLOADING_XMI, READY_TO_REASON, REASONING, NO_SOLUTION, READY_TO_CHOOSE, READY_TO_DEPLOY, DEPLOYING, DEPLOYED, RUNNING, IN_ERROR;

        public static State fromString(String name) {
            return getEnumFromString(State.class, name);
        }
    }

    public enum Action {
        UNCHANGED,                       // If no arrow in state diagram, don't do anything
        CREATE,                          // Resource being created by user
        UPLOAD_XMI,                      // XMI being uploaded by user
        XMI_UPLOADED,                    // XMI file uploaded into CDO
        START_REASONNING,                // Reasoning started by user
        REASONNED_NO_PLAN,               // Reason outcome: NO Deployment PLAN (by PaaSage)
        REASONNED_ONE_PLAN,              // Reason outcome:  One Deployment plan (by PaaSage)
        REASONNED_MULTI_PLANS,           // Reason outcome: Multiple Deployment plans (by PaaSage)
        CHOOSE_PLAN,                     // Plan being chosen by user
        DEPLOY,                          // Deployment started by user
        FINISH_DEPLOYMENT,               // Deployment finished ( by PaaSage)
        RUN;                              // Application start requested by PaaSage

        public static Action fromString(String name) {
            return getEnumFromString(Action.class, name);
        }
    }


    public PaasageModel(@Nullable List<Link> links, String name, String action, String state, String subState, String xmiModelEncoded) {
        super(links);
        this.name = name;
        this.action = action;
        this.state = state;
        this.subState = subState;
        this.xmiModelEncoded = xmiModelEncoded;
    }

    public PaasageModel(String name, String action, String state, String subState, String xmiModelEncoded) {
        this(null, name, action, state, subState, xmiModelEncoded);
    }

    protected PaasageModel() {

    }

    private String name;
    /**
     * State of the PaaSage Model.
     */
    private String state;

    /**
     * Sub State of the PaaSage Model.
     */
    private String subState;

    /**
     * Current Executing Action of the PaaSage Model.
     */
    private String action;

    /**
     * XMI file as uploaded by the api Caller (must be Base64 encoded)
     */
    private String xmiModelEncoded;

    public String getState() {
        return state;
    }

    public State getStateEnum() {
        return State.fromString(state);
    }

    public void setState(String state) {
        checkNotNull(state);
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubState() {
        return subState;
    }

    public void setSubState(String subState) {
        checkNotNull(subState);
        this.subState = subState;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        checkNotNull(action);
        this.action = action;
    }

    public Action getActionEnum() {
        return Action.fromString(action);
    }


    public String getXmiModelEncoded() {
        return xmiModelEncoded;
    }

    public void setXmiModelEncoded(String xmiModelEncoded) {
        this.xmiModelEncoded = xmiModelEncoded;
    }

    // Kind of getter but for computed fields
    public String decodeXmiModel() {
        // Do not decode then SENTINEL
        if ("UNCHANGED".equalsIgnoreCase(xmiModelEncoded))
            return xmiModelEncoded;
        byte[] decoded = Base64.getDecoder().decode(xmiModelEncoded);
        String decodedString = new String(decoded);
        return decodedString;
    }

    // Kind of setter for computed field
    public void encodeXmiModel(String xmiModelDecoded){
        byte[] encoded = Base64.getEncoder().encode(xmiModelDecoded.getBytes());
        this.xmiModelEncoded =new String(encoded);
    }
}
