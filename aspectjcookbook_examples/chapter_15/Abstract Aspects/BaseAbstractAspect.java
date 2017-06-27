
/**
 * <p>Title: BaseAspect aspect for Recipe 12.2</p>
 * <p>Description: Simple aspect for demonstrating the ability to define and implement abstract aspects</p>
 * <p>Copyright: Copyright (c) 2003 Russell Miles</p>
 * @author Russell Miles
 * @version 1.0
 */

public abstract aspect BaseAbstractAspect 
{
   /*
   Specifies an abstract pointcut placeholder
   for derived aspects to specify
   */
   abstract pointcut abstractBasePointcut();

   /*
   	Specifies calling advice whenever a jhin point
   	picked by the abstractBasePointcut (specified
   	by specialized aspects) is encountered, and not within
   	this aspect or any inheriting aspects.
   	*/
   pointcut runAdvicePointcut() : abstractBasePointcut()
      && !within(BaseAbstractAspect +);
}
