/**
 * @author t.j.
 * @date 2014-03
 *
 * The @Deprecated annotation marks an element programmers are discouraged from using.
 * It is used if the element (method, class etc.) is outdated, unsafe or if 
 * a better alternative exists.
 *
 *      'Note: MyHouse.java uses or overrides a deprecated API.'
 *
 * Prevent this Message by: 
 *      1.  marking the element in every implementing class as @Deprecated or
 *      2.  declaring '@interface Deprecated {}' in a file 'Deprecated.java'
 */
public interface House { 
    @Deprecated
    void open();
    void openFrontDoor();
    void openBackDoor();
}